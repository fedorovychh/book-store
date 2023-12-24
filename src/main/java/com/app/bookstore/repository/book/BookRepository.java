package com.app.bookstore.repository.book;

import com.app.bookstore.model.Book;
import com.app.bookstore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> getBooksByCategoriesContaining(Category category);
}
