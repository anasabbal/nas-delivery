package com.nas.deliv.categoryservice.dto.mapper;

import com.nas.deliv.categoryservice.dto.CategoryDto;
import com.nas.deliv.categoryservice.models.Category;
import org.mapstruct.Mapper;

import java.util.List;



@Mapper(componentModel = "spring")
public abstract class CategoryMapper {
    public abstract CategoryDto toDto(Category category);
    public abstract List<CategoryDto> toListDtos(List<Category> categories);
}
