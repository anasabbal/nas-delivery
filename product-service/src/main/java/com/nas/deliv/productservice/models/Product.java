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

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "PRICE")
    private Float price;


    public static Product create(final ProductCommand command){
        final Product product = new Product();

        product.productName = command.getProductName();
        product.companyName = command.getCompanyName();
        product.price = command.getPrice();

        return product;
    }
}
