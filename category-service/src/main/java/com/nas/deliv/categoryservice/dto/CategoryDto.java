package com.nas.deliv.categoryservice.dto;

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
    private Set<String> products;
    private String companyId;
}