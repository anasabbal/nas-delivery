package com.nas.deliv.brandservice.service;


import com.nas.deliv.brandservice.command.CompanyCommand;
import com.nas.deliv.brandservice.models.Company;
import com.nas.deliv.brandservice.repository.CompanyRepository;
import exception.BusinessException;
import exception.ExceptionPayloadFactory;
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

        if(!isExistByCeo(command.getCustomerId())){
            log.info("Begin creating company with payload {}", JSONUtil.toJSON(command));
            final Company company = Company.create(command);
            company.setCeo(command.getCustomerId());
            log.info("Company with id {} created successfully!", company.getId());
            return companyRepository.save(company);
        }
        throw new BusinessException(ExceptionPayloadFactory.EMAIL_ALREADY_EXIST.get());
    }
    private boolean isExistByCeo(String ceo){
        return companyRepository.existsByCeo(ceo);
    }
}
