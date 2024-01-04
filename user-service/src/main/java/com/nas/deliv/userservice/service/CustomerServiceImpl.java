package com.nas.deliv.userservice.service;


import com.nas.deliv.userservice.command.CustomerCreatedCommand;
import com.nas.deliv.userservice.models.AccountInformation;
import com.nas.deliv.userservice.models.Customer;
import com.nas.deliv.userservice.repository.CustomerRepository;
import exception.BusinessException;
import exception.ExceptionPayloadFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import util.JSONUtil;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    @Override
    public Customer create(CustomerCreatedCommand command) {
        if(!existByEmail(command.getEmail())){
            log.info("Begin creating Account with payload {}", JSONUtil.toJSON(command));
            final Customer customer = Customer.create(command);
            log.info("Customer with id {} created successfully !", customer.getId());
            return customerRepository.save(customer);
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
    private boolean existByEmail(String email) {
        return customerRepository.existsCustomerByAccountInformation_Email(email);
    }
}
