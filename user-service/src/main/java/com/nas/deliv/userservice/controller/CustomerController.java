package com.nas.deliv.userservice.controller;


import com.nas.deliv.userservice.dto.CustomerDto;
import com.nas.deliv.userservice.dto.mapper.CustomerMapper;
import com.nas.deliv.userservice.models.AccountInformation;
import com.nas.deliv.userservice.models.Customer;
import com.nas.deliv.userservice.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static constants.ResourcePaths.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(V1 + CUSTOMERS)
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @GetMapping(ACCOUNT_INFORMATION + "/{customerId}")
    public ResponseEntity<AccountInformation> getAccountInformation(@PathVariable("customerId") final String customerId){
        final AccountInformation accountInformation = customerService.getFromCustomerId(customerId);
        return ResponseEntity.ok(accountInformation);
    }
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("customerId") final String customerId){
        final Customer customer = customerService.findById(customerId);
        return ResponseEntity.ok(customerMapper.toCustomerDto(customer));
    }
}
