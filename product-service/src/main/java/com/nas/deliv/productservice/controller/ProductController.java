package com.nas.deliv.productservice.controller;


import com.nas.deliv.productservice.command.ProductCommand;
import com.nas.deliv.productservice.models.Product;
import com.nas.deliv.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static constants.ResourcePaths.V1;

@RestController
@RequestMapping(V1)
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody final ProductCommand productCommand){
        final Product product = productService.create(productCommand);
        return ResponseEntity.ok(product);
    }
}
