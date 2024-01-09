package com.nas.deliv.brandservice.service;


import com.nas.deliv.brandservice.command.CompanyCommand;
import com.nas.deliv.brandservice.models.Company;
import com.nas.deliv.brandservice.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import util.JSONUtil;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository companyRepository;

    @Override
    public Company create(CompanyCommand command) {
        log.info("Begin creating company with payload {}", JSONUtil.toJSON(command));
        final Company company = Company.create(command);
        log.info("Company with id {} created sussfully!", company.getId());
        return companyRepository.save(company);
    }
}
