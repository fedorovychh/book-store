package com.app.bookstore.service;

import com.app.bookstore.dto.BookDto;
import com.app.bookstore.dto.CreateBookRequestDto;
import java.util.List;

public interface BookService {

    BookDto save(CreateBookRequestDto requestDto);

    BookDto findById(Long id);

    List<BookDto> findAll();
}
