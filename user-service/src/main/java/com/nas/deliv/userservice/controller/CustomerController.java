package com.nas.deliv.userservice.controller;


import com.nas.deliv.userservice.command.AccountInformationUpdatedCommand;
import com.nas.deliv.userservice.dto.CustomerDto;
import com.nas.deliv.userservice.dto.mapper.CustomerMapper;
import com.nas.deliv.userservice.models.AccountInformation;
import com.nas.deliv.userservice.models.Customer;
import com.nas.deliv.userservice.service.account.AccountInformationService;
import com.nas.deliv.userservice.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static constants.ResourcePaths.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(V1 + CUSTOMERS)
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;
    private final AccountInformationService accountInformationService;


    @GetMapping
    @Cacheable(value = "customers", key = "{#pageable.pageNumber, #pageable.pageSize}")
    public ResponseEntity<Page<CustomerDto>> getCustomers(Pageable pageable){
        final Page<Customer> customers = customerService.getCustomers(pageable);
        return ResponseEntity.ok(customers.map(customerMapper::toCustomerDto));
    }
    @GetMapping(ACCOUNT_INFORMATION + "/{customerId}")
    @Cacheable(value = "accountInformation", key = "#customerId")
    public ResponseEntity<AccountInformation> getAccountInformation(@PathVariable("customerId") final String customerId){
        final AccountInformation accountInformation = customerService.getFromCustomerId(customerId);
        return ResponseEntity.ok(accountInformation);
    }
    @GetMapping("/{customerId}")
    @Cacheable(value = "customer", key = "#customerId")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("customerId") final String customerId){
        final Customer customer = customerService.findById(customerId);
        return ResponseEntity.ok(customerMapper.toCustomerDto(customer));
    }
    @PutMapping("/account-information/{customerId}")
    public ResponseEntity<AccountInformation> update(@PathVariable("customerId") String customerId,
                                                     @RequestBody AccountInformationUpdatedCommand command){
        final AccountInformation accountInformation = accountInformationService.update(customerId, command);
        return ResponseEntity.ok(accountInformation);
    }
    @DeleteMapping("{customerId}")
    public ResponseEntity<Void> deleteById(@PathVariable("customerId") final String customerId){
        customerService.deleteCustomerById(customerId);
        return ResponseEntity.noContent().build();
    }
}
