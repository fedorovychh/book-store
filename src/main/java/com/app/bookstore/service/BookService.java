package com.app.bookstore.service;

import java.util.List;
import com.app.bookstore.model.Book;

public interface BookService {

    Book save(Book book);

    List<Book> findAll();
}
