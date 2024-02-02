package com.nas.deliv.categoryservice.service;

import com.nas.deliv.categoryservice.command.CategoryCommand;
import com.nas.deliv.categoryservice.models.Category;

public interface CategoryService {
    Category create(final CategoryCommand command);
    Category findByCompanyId(String companyId);
}
