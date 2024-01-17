package com.nas.deliv.productservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shared.BaseDto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto extends BaseDto {
    private String productName;
    private String companyName;
    private Float price;
}
