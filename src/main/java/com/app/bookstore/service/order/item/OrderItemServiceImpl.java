package com.app.bookstore.service.order.item;

import com.app.bookstore.model.OrderItem;
import com.app.bookstore.repository.order.OrderRepository;
import com.app.bookstore.repository.order.item.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> getAllById(Long id) {
        return orderItemRepository.findAllById(id);
    }
}
