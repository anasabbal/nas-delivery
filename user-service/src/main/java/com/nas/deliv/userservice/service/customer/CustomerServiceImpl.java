package com.nas.deliv.userservice.service.customer;


import com.nas.deliv.userservice.command.CustomerCreatedCommand;
import com.nas.deliv.userservice.event.request.CreateBrandRequest;
import com.nas.deliv.userservice.models.AccountInformation;
import com.nas.deliv.userservice.models.ConfirmationToken;
import com.nas.deliv.userservice.models.Customer;
import com.nas.deliv.userservice.repository.ConfirmationTokenRepository;
import com.nas.deliv.userservice.repository.CustomerRepository;
import com.nas.deliv.userservice.service.EmailService;
import com.nas.deliv.userservice.service.feign.BrandFeignService;
import exception.BusinessException;
import exception.ExceptionPayloadFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import util.JSONUtil;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final BrandFeignService brandFeignService;
    private final CustomerRepository customerRepository;
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final EmailService emailService;

    @Value("${path.app}")
    private String pathApp;

    @Override
    public String create(CustomerCreatedCommand command) {
        if(!existByEmail(command.getEmail())){
            log.info("Begin creating Account with payload {}", JSONUtil.toJSON(command));
            final Customer customer = Customer.create(command);

            log.info("Customer with id {} created successfully !", customer.getId());
            customerRepository.save(customer);
            final CreateBrandRequest createBrandRequest = CreateBrandRequest.create(
                    customer.getAccountInformation().getFirstName(),
                    null, customer.getId()
            );
            brandFeignService.createBrand(createBrandRequest);

            final ConfirmationToken confirmationToken = createConfirmationToken(customer);

            sendEmail(customer, confirmationToken);

            return "Verify email by the link sent on your email address";
        }
        throw new BusinessException(ExceptionPayloadFactory.EMAIL_ALREADY_EXIST.get());
    }
    @Override
    public AccountInformation getFromCustomerId(String customerId){
        final Customer customer = findById(customerId);
        return customer.getAccountInformation();
    }
    @Override
    public Customer findById(String customerId){
        log.info("Begin fetching customer with id {}", customerId);
        final Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new BusinessException(ExceptionPayloadFactory.CUSTOMER_NOT_FOUND.get())
        );
        log.info("Customer with id {} fetched successfully !", customerId);
        return customer;
    }

    @Override
    public Page<Customer> getCustomers(Pageable pageable) {
        return customerRepository.findAllByDeletedFalse(pageable);
    }
    private ConfirmationToken createConfirmationToken(Customer customer){
        log.info("Begin creating confirmation token");
        final ConfirmationToken confirmationToken = new ConfirmationToken(customer);
        log.info("Confirmation token with token id {} created successfully !", confirmationToken.getTokenId());
        confirmationTokenRepository.save(confirmationToken);

        return confirmationToken;
    }
    private void sendEmail(Customer customer, ConfirmationToken confirmationToken){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        final AccountInformation accountInformation = getAccountInformationFromCustomer(customer);
        mailMessage.setTo(accountInformation.getEmail());
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setText("To confirm your account, please click here : "
                + pathApp + "confirm-account?token="+confirmationToken.getConfirmationToken());
        emailService.sendEmail(mailMessage);
    }

    private AccountInformation getAccountInformationFromCustomer(Customer customer){
        return customer.getAccountInformation();
    }


    private boolean existByEmail(String email) {
        return customerRepository.existsCustomerByAccountInformation_Email(email);
    }
}
