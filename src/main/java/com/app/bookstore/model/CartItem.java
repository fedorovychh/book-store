package com.app.bookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private ShoppingCart shoppingCart;
    @JoinColumn(nullable = false, name = "book_id")
    @ManyToOne
    private Book book;
    @Column(nullable = false)
    private int quantity;
}
