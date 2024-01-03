package com.app.bookstore.dto.order;

import com.app.bookstore.model.OrderItem;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class OrderResponseDto {
    private Long id;
    private Long userId;
    private List<OrderItem> orderItems;
    private LocalDateTime orderDate;
    private BigDecimal total;
    private String status;
}
