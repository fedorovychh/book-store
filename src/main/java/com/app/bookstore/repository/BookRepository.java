package com.app.bookstore.repository;

import com.app.bookstore.model.Book;
import java.util.List;

public interface BookRepository {

    Book save(Book book);

    Book findById(Long id);

    List<Book> findAll();
}
