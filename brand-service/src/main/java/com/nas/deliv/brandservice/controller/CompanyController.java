package com.nas.deliv.brandservice.controller;


import com.nas.deliv.brandservice.command.CompanyCommand;
import com.nas.deliv.brandservice.models.Company;
import com.nas.deliv.brandservice.service.CompanyService;
import com.nas.deliv.brandservice.service.feign.request.CategoryCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/category")
    public ResponseEntity<String> createCategory(@RequestBody CategoryCommand categoryCommand){
        return ResponseEntity.ok(companyService.createCategory(categoryCommand));
    }
    @GetMapping("/{companyId}")
    public ResponseEntity<Company> findById(@PathVariable("companyId") final String companyId){
        return ResponseEntity.ok(companyService.findById(companyId));
    }
}
