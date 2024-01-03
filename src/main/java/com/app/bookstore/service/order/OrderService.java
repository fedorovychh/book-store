package com.app.bookstore.service.order;

import com.app.bookstore.dto.order.OrderRequestDto;
import com.app.bookstore.dto.order.OrderResponseDto;

public interface OrderService {
    OrderResponseDto placeOrder(OrderRequestDto requestDto);
}
