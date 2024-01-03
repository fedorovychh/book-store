package com.app.bookstore.service.order;

import com.app.bookstore.dto.order.OrderRequestDto;
import com.app.bookstore.dto.order.OrderResponseDto;
import com.app.bookstore.mapper.OrderMapper;
import com.app.bookstore.model.Order;
import com.app.bookstore.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public OrderResponseDto placeOrder(OrderRequestDto requestDto) {
        Order order = orderMapper.toOrder(requestDto);
        return orderMapper.toDto(orderRepository.save(order));
    }

    @Override
    public List<Order> getAll(Long id) {
        return orderRepository.findAllById(id);
    }
}
