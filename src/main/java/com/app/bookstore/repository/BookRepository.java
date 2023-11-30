package com.app.bookstore.repository;

import java.util.List;
import com.app.bookstore.model.Book;

public interface BookRepository {

    Book save(Book book);

    List<Book> findAll();
}
