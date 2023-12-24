package com.app.bookstore.service.category;

import com.app.bookstore.dto.category.CategoryResponseDto;
import com.app.bookstore.dto.category.CreateCategoryRequestDto;
import com.app.bookstore.model.Category;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDto> findAll(Pageable pageable);

    CategoryResponseDto getById(Long id);

    CategoryResponseDto save(CreateCategoryRequestDto requestDto);

    CategoryResponseDto update(Long id, CreateCategoryRequestDto requestDto);

    void deleteById(Long id);
}
