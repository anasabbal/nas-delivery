package com.nas.deliv.productservice.dto.mapper;


import com.nas.deliv.productservice.dto.ProductDto;
import com.nas.deliv.productservice.models.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {

    public abstract ProductDto toDto(Product product);
    public abstract List<ProductDto> toListDto(List<Product> products);
}
