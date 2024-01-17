package com.nas.deliv.productservice.service.category;

import com.nas.deliv.productservice.command.CategoryCommand;
import com.nas.deliv.productservice.models.Category;

public interface CategoryService {

    Category create(final CategoryCommand command);
    Category findByCompanyId(String companyId);

}
