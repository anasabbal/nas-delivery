package com.nas.deliv.productservice.models;

import com.nas.deliv.productservice.command.CategoryCommand;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import shared.BaseEntity;

import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Category extends BaseEntity {

    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;

    private String companyId;

    public static Category create(CategoryCommand command) {
        final Category category = new Category();

        category.categoryName = command.getCategoryName();
        category.products = new HashSet<>();
        category.companyId = command.getCompanyId();

        return category;
    }
}
