package com.app.bookstore.service;

import com.app.bookstore.dto.BookDto;
import com.app.bookstore.model.Book;
import java.util.List;

public interface BookService {

    Book save(Book book);

    List<BookDto> findAll();
}
