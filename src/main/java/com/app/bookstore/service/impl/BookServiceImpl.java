package com.app.bookstore.service.impl;

import com.app.bookstore.dto.BookDto;
import com.app.bookstore.mapper.BookMapper;
import com.app.bookstore.model.Book;
import com.app.bookstore.repository.BookRepository;
import com.app.bookstore.service.BookService;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toDto)
                .toList();
    }
}
