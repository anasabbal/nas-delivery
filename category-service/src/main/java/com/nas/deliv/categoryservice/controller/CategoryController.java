package com.nas.deliv.categoryservice.controller;

import com.nas.deliv.categoryservice.command.CategoryCommand;
import com.nas.deliv.categoryservice.dto.CategoryDto;
import com.nas.deliv.categoryservice.dto.mapper.CategoryMapper;
import com.nas.deliv.categoryservice.models.Category;
import com.nas.deliv.categoryservice.service.CategoryService;
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
        categoryService.create(categoryCommand);
        return ResponseEntity.ok("Created successfully!");
    }
}
