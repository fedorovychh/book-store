package com.app.bookstore.repository.book;

import com.app.bookstore.model.Book;
import com.app.bookstore.model.Category;
import java.math.BigDecimal;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Pageable;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    private static Book book;

    @BeforeAll
    static void beforeAll() {
        Category category = new Category();
        category.setId(1L);
        category.setName("Test category");
        category.setDescription("Category for tests");

        book = new Book();
        book.setId(1L);
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        book.setIsbn("9783161484100");
        book.setPrice(BigDecimal.valueOf(17.50));
        book.setDescription("Description for test book");
        book.setCategories(Set.of(category));
    }

    @Test
    @DisplayName("Find all books from DB with one book")
    void findAll_OneBook_ReturnsCorrectData() {
        bookRepository.save(book);
        Book bookFromDb = bookRepository.findAll(Pageable.ofSize(1)).stream()
                .findFirst()
                .get();
        String expected = book.getTitle();
        String actual = bookFromDb.getTitle();
        Assertions.assertEquals(expected, actual,
                "Expected book title: " + expected
                + " but was: " + actual
        );
    }
}
