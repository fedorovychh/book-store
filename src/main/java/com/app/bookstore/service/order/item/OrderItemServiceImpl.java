package com.app.bookstore.service.order.item;

import com.app.bookstore.dto.order.item.OrderItemResponseDto;
import com.app.bookstore.exception.EntityNotFoundException;
import com.app.bookstore.mapper.OrderItemMapper;
import com.app.bookstore.model.OrderItem;
import com.app.bookstore.repository.order.item.OrderItemRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;

    @Override
    public List<OrderItem> getAllById(Long id) {
        return orderItemRepository.findAllById(id);
    }

    @Override
    public OrderItemResponseDto getItemById(Long id, Long itemId) {
        OrderItem orderItem = orderItemRepository.findById(id, itemId).orElseThrow(
                () -> new EntityNotFoundException("Can't find item by id: " + id)
        );
        return orderItemMapper.toDto(orderItem);
    }
}
