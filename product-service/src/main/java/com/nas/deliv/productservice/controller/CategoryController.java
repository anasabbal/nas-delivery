package com.nas.deliv.productservice.controller;


import com.nas.deliv.productservice.command.CategoryCommand;
import com.nas.deliv.productservice.dto.CategoryDto;
import com.nas.deliv.productservice.dto.mapper.CategoryMapper;
import com.nas.deliv.productservice.models.Category;
import com.nas.deliv.productservice.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static constants.ResourcePaths.CATEGORY;
import static constants.ResourcePaths.V1;

@RestController
@RequestMapping(V1 + CATEGORY)
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;



    @GetMapping("/{companyId}")
    public ResponseEntity<CategoryDto> findByCompanyId(@PathVariable("companyId") final String companyId){
        final Category category = categoryService.findByCompanyId(companyId);
        return ResponseEntity.ok(categoryMapper.toDto(category));
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody final CategoryCommand categoryCommand){
        final Category category = categoryService.create(categoryCommand);
        return ResponseEntity.ok("Created !!!!!!!");
    }
}
