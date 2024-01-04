package com.app.bookstore.service.order.item;

import com.app.bookstore.dto.order.item.OrderItemResponseDto;
import java.util.List;

public interface OrderItemService {

    List<OrderItemResponseDto> getAllById(Long id);

    OrderItemResponseDto getItemById(Long id, Long itemId);
}
