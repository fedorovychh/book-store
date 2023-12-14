package com.app.bookstore.service.book;

import com.app.bookstore.dto.BookDto;
import com.app.bookstore.dto.CreateBookRequestDto;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface BookService {
    BookDto save(CreateBookRequestDto requestDto);

    BookDto findById(Long id);

    List<BookDto> findAll(Pageable pageable);

    void deleteBookById(Long id);

    BookDto updateBookById(Long id, CreateBookRequestDto bookDto);
}
