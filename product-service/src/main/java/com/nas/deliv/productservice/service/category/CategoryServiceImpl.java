package com.nas.deliv.productservice.service.category;


import com.nas.deliv.productservice.command.CategoryCommand;
import com.nas.deliv.productservice.models.Category;
import com.nas.deliv.productservice.repository.CategoryRepository;
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
}
