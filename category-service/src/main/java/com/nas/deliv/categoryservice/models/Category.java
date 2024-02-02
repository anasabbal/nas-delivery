package com.nas.deliv.categoryservice.models;


import com.nas.deliv.categoryservice.command.CategoryCommand;
import jakarta.persistence.*;
import shared.BaseEntity;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Category extends BaseEntity {

    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    @ElementCollection
    @CollectionTable(name = "CATEGORY_PRODUCTS", joinColumns = @JoinColumn(name = "CATEGORY_ID"))
    @Column(name = "PRODUCT_ID")
    private Set<String> products;

    @Column(name = "CATEGORY_NAME")
    private String companyId;

    public static Category create(CategoryCommand command) {
        final Category category = new Category();

        category.categoryName = command.getCategoryName();
        category.products = new HashSet<>();
        category.companyId = command.getCompanyId();

        return category;
    }
}
