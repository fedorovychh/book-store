package com.app.bookstore.dto.order;

import com.app.bookstore.model.Order;
import lombok.Data;

@Data
public class UpdateOrderRequestDto {
    private Order.Status status;
}
