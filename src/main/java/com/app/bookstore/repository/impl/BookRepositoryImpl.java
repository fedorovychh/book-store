package com.app.bookstore.repository.impl;

import com.app.bookstore.exception.DataProcessingException;
import com.app.bookstore.model.Book;
import com.app.bookstore.repository.BookRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class BookRepositoryImpl implements BookRepository {
    private static final String SAVING_FAILURE_MESSAGE = "Can't save book {%s} to database!";
    private static final String FIND_ALL_FAILURE_MESSAGE = "Can't find all books from DB";

    private final SessionFactory sessionFactory;

    @Override
    public Book save(Book book) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(book);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException(String.format(SAVING_FAILURE_MESSAGE, book), ex);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return book;
    }

    @Override
    public List<Book> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Book> books = session.createQuery("FROM Book b", Book.class);
            return books.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException(FIND_ALL_FAILURE_MESSAGE, e);
        }
    }
}
