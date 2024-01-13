package com.nas.deliv.productservice.service;


import com.nas.deliv.productservice.command.ProductCommand;
import com.nas.deliv.productservice.models.Product;
import com.nas.deliv.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public Product create(ProductCommand command) {
        return null;
    }
}
