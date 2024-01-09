package com.app.bookstore.service.book;

import com.app.bookstore.dto.book.BookDto;
import com.app.bookstore.mapper.BookMapper;
import com.app.bookstore.model.Book;
import com.app.bookstore.model.Category;
import com.app.bookstore.repository.book.BookRepository;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {
    @Mock
    private static BookRepository bookRepository;
    @Mock
    private static BookMapper bookMapper;
    @InjectMocks
    private static BookServiceImpl bookServiceImpl;
    private static Book book;
    private static BookDto bookDto;

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

        bookDto = new BookDto();
        bookDto.setId(1L);
        bookDto.setTitle("Test Book");
        bookDto.setAuthor("Test Author");
        bookDto.setIsbn("9783161484100");
        bookDto.setPrice(BigDecimal.valueOf(17.50));
        bookDto.setDescription("Description for test book");
        bookDto.setCategoryIds(Set.of(1L));
    }

    @Test
    @DisplayName("Find book by correct id")
    void findById_ValidData_ReturnsCorrectBookDto() {
        Long id = 1L;
        Mockito.when(bookRepository.findById(id)).thenReturn(Optional.of(book));
        Mockito.when(bookMapper.toDto(book)).thenReturn(bookDto);
        BookDto expected = bookDto;
        BookDto actual = bookServiceImpl.findById(id);
        Assertions.assertEquals(expected, actual,
                "Expected BookDto should be: " + expected
                + " but was: " + actual
        );
    }
}
