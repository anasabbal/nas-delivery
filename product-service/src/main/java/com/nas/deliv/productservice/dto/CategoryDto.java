package com.nas.deliv.productservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shared.BaseDto;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto extends BaseDto {

    private String categoryName;
    private Set<ProductDto> products;
    private String companyId;
}
