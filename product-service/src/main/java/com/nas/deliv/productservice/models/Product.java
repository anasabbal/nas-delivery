package com.nas.deliv.productservice.models;

import jakarta.persistence.Entity;
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
}
