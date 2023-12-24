package com.app.bookstore.service.category;

import com.app.bookstore.dto.category.CategoryResponseDto;
import com.app.bookstore.dto.category.CreateCategoryRequestDto;
import com.app.bookstore.exception.EntityNotFoundException;
import com.app.bookstore.mapper.CategoryMapper;
import com.app.bookstore.model.Book;
import com.app.bookstore.model.Category;
import com.app.bookstore.repository.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryResponseDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toDto)
                .toList();
    }

    @Override
    public CategoryResponseDto getById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() ->
                new EntityNotFoundException("Can't find category by id: " + id));
        return categoryMapper.toDto(category);
    }

    @Override
    public CategoryResponseDto save(CreateCategoryRequestDto requestDto) {
        Category category = categoryMapper.toCategory(requestDto);
        return categoryMapper.toDto(categoryRepository.save(category));
    }

    @Override
    public CategoryResponseDto update(Long id, CreateCategoryRequestDto requestDto) {
        if (!categoryRepository.existsById(id)) {
            throw new EntityNotFoundException("Can't find category by id: " + id);
        }
        Category category = categoryMapper.toCategory(requestDto);
        category.setId(id);
        return categoryMapper.toDto(categoryRepository.save(category));
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
