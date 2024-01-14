package com.nas.deliv.productservice.controller;


import com.nas.deliv.productservice.command.CategoryCommand;
import com.nas.deliv.productservice.models.Category;
import com.nas.deliv.productservice.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static constants.ResourcePaths.CATEGORY;
import static constants.ResourcePaths.V1;

@RestController
@RequestMapping(V1 + CATEGORY)
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


    @PostMapping
    public ResponseEntity<String> create(@RequestBody final CategoryCommand categoryCommand){
        final Category category = categoryService.create(categoryCommand);
        return ResponseEntity.ok("Created !!!!!!!");
    }
}
