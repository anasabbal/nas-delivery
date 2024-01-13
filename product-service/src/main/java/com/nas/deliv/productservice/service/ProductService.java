package com.nas.deliv.productservice.service;

import com.nas.deliv.productservice.command.ProductCommand;
import com.nas.deliv.productservice.models.Product;

public interface ProductService {
    Product create(final ProductCommand command);
}
