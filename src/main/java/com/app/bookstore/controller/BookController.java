package com.app.bookstore.controller;

import com.app.bookstore.model.Book;
import com.app.bookstore.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<Book> getAll() {
        return bookService.findAll();
    }

    @GetMapping(value = "/{id}")
    public BookDto getBookById(Long id) {
        return bookService.findById();
    }

    @PostMapping
    public Book createBook(CreateBookRequestDto bookDto) {
        return bookService.save(bookDto);
    }


}
