package com.nas.deliv.userservice.controller;


import com.nas.deliv.userservice.command.CustomerCreatedCommand;
import com.nas.deliv.userservice.models.Customer;
import com.nas.deliv.userservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static constants.ResourcePaths.*;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;


@RestController
@RequiredArgsConstructor
@RequestMapping(V1 + AUTH)
public class AuthController {

    private final CustomerService customerService;

    @PostMapping(REGISTER)
    public ResponseEntity<String> register(@RequestBody CustomerCreatedCommand command){
        final Customer customer = customerService.create(command);
        final URI uri = fromCurrentRequest().path("/{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.ok(uri.toString());
    }

}
