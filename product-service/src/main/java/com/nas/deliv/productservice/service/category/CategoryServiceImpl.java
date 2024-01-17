package com.nas.deliv.productservice.service.category;


import com.nas.deliv.productservice.command.CategoryCommand;
import com.nas.deliv.productservice.models.Category;
import com.nas.deliv.productservice.repository.CategoryRepository;
import exception.BusinessException;
import exception.ExceptionPayloadFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import util.JSONUtil;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;


    @Override
    public Category create(CategoryCommand command) {
        log.info("Begin creating category with payload {}", JSONUtil.toJSON(command));
        final Category category = Category.create(command);

        return categoryRepository.save(category);
    }

    @Override
    public Category findByCompanyId(String companyId) {
        log.info("Begin fetching Category with company id {}", companyId);
        final Category category = categoryRepository.findByCompanyId(companyId).orElseThrow(
                () -> new BusinessException(ExceptionPayloadFactory.CATEGORY_FOR_COMPANY_ID_NOT_FOUND.get())
        );
        log.info("Category fetched successfully");
        return category;
    }
}
