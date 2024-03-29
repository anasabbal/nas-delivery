package com.nas.deliv.productservice.repository;

import com.nas.deliv.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    Optional<Category> findByCompanyId(String companyId);
}
