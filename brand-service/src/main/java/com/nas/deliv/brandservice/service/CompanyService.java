package com.nas.deliv.brandservice.service;

import com.nas.deliv.brandservice.command.CompanyCommand;
import com.nas.deliv.brandservice.models.Company;
import com.nas.deliv.brandservice.service.feign.request.CategoryCommand;

public interface CompanyService {
    String createCategory(CategoryCommand categoryCommand);
    Company create(final CompanyCommand command);
    Company findById(String companyId);
}
