package com.app.bookstore.repository.cart.item;

import com.app.bookstore.model.Book;
import com.app.bookstore.model.CartItem;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    @Query("SELECT b FROM CartItem b JOIN FETCH b.shoppingCart")
    Page<CartItem> findAll(Pageable pageable);

    @Query("SELECT b FROM CartItem b JOIN fetch b.shoppingCart c WHERE c.id = :itemId")
    List<Book> findAllByItemId(Long itemId);
}
