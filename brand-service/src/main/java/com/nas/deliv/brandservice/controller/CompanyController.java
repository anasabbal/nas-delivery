package com.nas.deliv.brandservice.controller;


import com.nas.deliv.brandservice.command.CompanyCommand;
import com.nas.deliv.brandservice.models.Company;
import com.nas.deliv.brandservice.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static constants.ResourcePaths.COMPANY;
import static constants.ResourcePaths.V1;

@RestController
@RequestMapping(V1 + COMPANY)
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;


    @PostMapping
    public ResponseEntity<Company> create(@RequestBody final CompanyCommand companyCommand){
        final Company company = companyService.create(companyCommand);
        return ResponseEntity.ok(company);
    }
}
