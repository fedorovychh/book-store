package com.app.bookstore.service.order;

import com.app.bookstore.dto.order.OrderRequestDto;
import com.app.bookstore.dto.order.OrderResponseDto;
import com.app.bookstore.dto.order.UpdateOrderRequestDto;
import com.app.bookstore.model.User;
import java.util.List;

public interface OrderService {
    OrderResponseDto placeOrder(Long id, OrderRequestDto requestDto);

    List<OrderResponseDto> getAll(Long id);

    OrderResponseDto updateStatus(Long id, UpdateOrderRequestDto requestDto);
}
