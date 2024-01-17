package com.nas.deliv.userservice.controller;


import com.nas.deliv.userservice.command.CustomerCreatedCommand;
import com.nas.deliv.userservice.service.customer.CustomerService;
import com.nas.deliv.userservice.service.token.ConfirmationTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static constants.ResourcePaths.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(V1 + AUTH)
public class AuthController {

    private final CustomerService customerService;
    private final ConfirmationTokenService confirmationTokenService;

    @PostMapping(REGISTER)
    public ResponseEntity<String> register(@RequestBody CustomerCreatedCommand command){
        final String str = customerService.create(command);
        return ResponseEntity.ok(str);
    }

    @GetMapping("/confirm-account")
    public ResponseEntity<?> confirmUserAccount(@RequestParam("token")String confirmationToken) {
        confirmationTokenService.confirmEmail(confirmationToken);
        return ResponseEntity.ok("Email verified successfully!");
    }
}