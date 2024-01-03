package com.app.bookstore.service.order.item;

import com.app.bookstore.model.OrderItem;
import com.app.bookstore.repository.order.item.OrderItemRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> getAllById(Long id) {
        return orderItemRepository.findAllById(id);
    }
}
