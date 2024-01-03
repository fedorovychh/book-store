package com.app.bookstore.repository.order.item;

import com.app.bookstore.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    @Query("SELECT oi FROM OrderItem oi "
            + "JOIN FETCH oi.order "
            + "JOIN FETCH oi.book "
            + "WHERE oi.order.id = :id")
    List<OrderItem> findAllById(Long id);
}
