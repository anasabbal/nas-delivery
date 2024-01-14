package com.nas.deliv.productservice.models;

import com.nas.deliv.productservice.command.ProductCommand;
import jakarta.persistence.*;
import lombok.*;
import shared.BaseEntity;




@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseEntity {
    private String productName;
    private String companyName;
    private Float price;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Category category;

    public static Product create(final ProductCommand command){
        final Product product = new Product();

        product.productName = command.getProductName();
        product.companyName = command.getCompanyName();
        product.price = command.getPrice();

        return product;
    }
}
