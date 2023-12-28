package com.app.bookstore.mapper;

import com.app.bookstore.config.MapperConfig;
import com.app.bookstore.dto.category.CategoryResponseDto;
import com.app.bookstore.dto.category.CreateCategoryRequestDto;
import com.app.bookstore.model.Category;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface CategoryMapper {
    CategoryResponseDto toDto(Category category);

    Category toCategory(CreateCategoryRequestDto requestDto);
}
