package com.nas.deliv.productservice.service.product;


import com.nas.deliv.productservice.command.ProductCommand;
import com.nas.deliv.productservice.models.Product;
import com.nas.deliv.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import util.JSONUtil;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public Product create(ProductCommand command) {
        log.info("Begin creating product with payload {}", JSONUtil.toJSON(command));
        final Product product = Product.create(command);
        log.info("Product with id {} created successfully!", product.getId());
        return productRepository.save(product);
    }

    @Override
    public Page<Product> findAllByCategoryId(String categoryId, Pageable pageable) {
        return productRepository.findAllByCategoryId(categoryId, pageable);
    }
}
