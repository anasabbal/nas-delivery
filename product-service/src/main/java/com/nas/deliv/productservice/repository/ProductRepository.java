package com.nas.deliv.productservice.repository;

import com.nas.deliv.productservice.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Page<Product> findAllByCategoryId(String categoryId, Pageable pageable);
}
