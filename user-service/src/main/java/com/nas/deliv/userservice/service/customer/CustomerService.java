package com.nas.deliv.userservice.service.customer;

import com.nas.deliv.userservice.command.CustomerCreatedCommand;
import com.nas.deliv.userservice.models.AccountInformation;
import com.nas.deliv.userservice.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    String create(final CustomerCreatedCommand command);
    Customer findById(String customerId);
    AccountInformation getFromCustomerId(String customerId);
    Page<Customer> getCustomers(Pageable pageable);
}
