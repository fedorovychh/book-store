package com.app.bookstore.service.book;

import com.app.bookstore.dto.book.BookDto;
import com.app.bookstore.dto.book.BookDtoWithoutCategoryIds;
import com.app.bookstore.dto.book.CreateBookRequestDto;
import com.app.bookstore.exception.EntityNotFoundException;
import com.app.bookstore.mapper.BookMapper;
import com.app.bookstore.model.Book;
import com.app.bookstore.repository.book.BookRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto save(CreateBookRequestDto requestDto) {
        Book book = bookMapper.toBook(requestDto);
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public BookDto findById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find book by id: " + id)
        );
        return bookMapper.toDto(book);
    }

    @Override
    public List<BookDto> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable)
                .stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookDto updateBookById(Long id, CreateBookRequestDto bookDto) {
        if (!bookRepository.existsById(id)) {
            throw new EntityNotFoundException("Can't find book by id: " + id);
        }
        Book book = bookMapper.toBook(bookDto);
        book.setId(id);
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public List<BookDtoWithoutCategoryIds> getBooksByCategoryId(Long id) {
        return bookRepository.findAllByCategoryId(id).stream()
                .map(bookMapper::toDtoWithoutCategories)
                .toList();
    }
}
