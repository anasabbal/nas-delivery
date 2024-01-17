package com.nas.deliv.productservice.controller;


import com.nas.deliv.productservice.command.ProductCommand;
import com.nas.deliv.productservice.dto.ProductDto;
import com.nas.deliv.productservice.dto.mapper.ProductMapper;
import com.nas.deliv.productservice.models.Product;
import com.nas.deliv.productservice.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static constants.ResourcePaths.V1;

@RestController
@RequestMapping(V1)
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;



    @GetMapping("/{categoryId}")
    public ResponseEntity<Page<ProductDto>> findAllByCategoryId(@PathVariable("categoryId") String categoryId, Pageable pageable){
        final Page<Product> products = productService.findAllByCategoryId(categoryId, pageable);
        final Page<ProductDto> productDtos = products.map(productMapper::toDto);
        return ResponseEntity.ok(productDtos);
    }
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody final ProductCommand productCommand){
        final Product product = productService.create(productCommand);
        return ResponseEntity.ok(product);
    }
}
