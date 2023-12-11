package com.app.bookstore.service.book;

import com.app.bookstore.dto.BookDto;
import com.app.bookstore.dto.CreateBookRequestDto;
import java.util.List;

public interface BookService {
    BookDto save(CreateBookRequestDto requestDto);

    BookDto findById(Long id);

    List<BookDto> findAll();

    void deleteBookById(Long id);

    BookDto updateBookById(Long id, CreateBookRequestDto createBookRequestDto);
}
