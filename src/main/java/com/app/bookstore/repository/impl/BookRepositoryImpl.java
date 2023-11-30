package com.app.bookstore.repository.impl;

import java.util.List;
import com.app.bookstore.model.Book;
import com.app.bookstore.repository.BookRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepository {

    @Override
    public Book save(Book book) {
        return null;
    }

    @Override
    public List<Book> findAll() {
        return null;
    }
}
