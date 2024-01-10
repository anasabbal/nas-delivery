package com.nas.deliv.userservice.service.account;


import com.nas.deliv.userservice.command.AccountInformationUpdatedCommand;
import com.nas.deliv.userservice.models.AccountInformation;
import com.nas.deliv.userservice.models.Customer;
import com.nas.deliv.userservice.repository.AccountInformationRepository;
import com.nas.deliv.userservice.repository.CustomerRepository;
import exception.BusinessException;
import exception.ExceptionPayloadFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountInformationServiceImpl implements AccountInformationService{

    private final CustomerRepository customerRepository;
    private final AccountInformationRepository accountInformationRepository;

    @Override
    public AccountInformation getByEmail(String email) {
        return accountInformationRepository.findByEmail(email).orElseThrow(
                () -> new BusinessException(ExceptionPayloadFactory.CUSTOMER_NOT_FOUND.get())
        );
    }

    @Override
    public AccountInformation update(String customerId, AccountInformationUpdatedCommand command) {
        final Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new BusinessException(ExceptionPayloadFactory.CUSTOMER_NOT_FOUND.get())
        );
        final AccountInformation accountInformation = customer.getAccountInformation();
        accountInformation.update(command);
        return accountInformationRepository.save(accountInformation);
    }
}
