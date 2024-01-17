package com.nas.deliv.productservice.service.product;

import com.nas.deliv.productservice.command.ProductCommand;
import com.nas.deliv.productservice.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Product create(final ProductCommand command);
    Page<Product> findAllByCategoryId(String categoryId, Pageable pageable);
}
