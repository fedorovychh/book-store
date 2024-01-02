package com.app.bookstore.repository.shopping.cart;

import com.app.bookstore.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    @Query("SELECT sc FROM ShoppingCart sc JOIN FETCH sc.cartItems ci WHERE sc.user.id = :userId")
    Optional<ShoppingCart> findByUserId(Long userId);
}
