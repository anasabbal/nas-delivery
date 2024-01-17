package com.nas.deliv.productservice.dto.mapper;


import com.nas.deliv.productservice.dto.CategoryDto;
import com.nas.deliv.productservice.models.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper {
    public abstract CategoryDto toDto(Category category);
    public abstract List<CategoryDto> toListDtos(List<Category> categories);
}
