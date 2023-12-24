package com.app.bookstore.service.book;

import com.app.bookstore.dto.book.BookDto;
import com.app.bookstore.dto.book.BookDtoWithoutCategoryIds;
import com.app.bookstore.dto.book.CreateBookRequestDto;
import java.util.List;

import com.app.bookstore.dto.category.CategoryResponseDto;
import org.springframework.data.domain.Pageable;

public interface BookService {
    BookDto save(CreateBookRequestDto requestDto);

    BookDto findById(Long id);

    List<BookDto> findAll(Pageable pageable);

    void deleteBookById(Long id);

    BookDto updateBookById(Long id, CreateBookRequestDto bookDto);

    List<BookDtoWithoutCategoryIds> getBooksByCategoryId(Long id);
}
