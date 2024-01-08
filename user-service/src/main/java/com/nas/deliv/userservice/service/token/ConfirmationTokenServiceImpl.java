package com.nas.deliv.userservice.service.token;


import com.nas.deliv.userservice.models.ConfirmationToken;
import com.nas.deliv.userservice.models.Customer;
import com.nas.deliv.userservice.repository.ConfirmationTokenRepository;
import com.nas.deliv.userservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService{

    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void confirmEmail(String confirmationToken) {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if(token != null)
        {
            Customer customer = customerRepository.findByAccountInformation_Email(token.getCustomer().getAccountInformation().getEmail());
            customer.setEnabled(true);
            customerRepository.save(customer);
            log.info("Email verified successfully!");
        }
        log.info("Error: Couldn't verify email");
    }
}
