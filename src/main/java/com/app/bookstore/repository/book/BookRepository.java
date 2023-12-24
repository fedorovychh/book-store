package com.app.bookstore.repository.book;

import com.app.bookstore.model.Book;
import com.app.bookstore.model.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> getBooksByCategoriesContaining(Category category);
}
