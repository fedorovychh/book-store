package com.app.bookstore.service.order.item;

import com.app.bookstore.dto.order.item.OrderItemResponseDto;
import com.app.bookstore.model.OrderItem;
import java.util.List;

public interface OrderItemService {

    List<OrderItem> getAllById(Long id);

    OrderItemResponseDto getItemById(Long id, Long itemId);
}
