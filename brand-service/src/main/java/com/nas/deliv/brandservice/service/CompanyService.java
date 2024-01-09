package com.nas.deliv.brandservice.service;

import com.nas.deliv.brandservice.command.CompanyCommand;
import com.nas.deliv.brandservice.models.Company;

public interface CompanyService {
    Company create(final CompanyCommand command);
}
