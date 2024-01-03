package com.app.bookstore.mapper;

import com.app.bookstore.config.MapperConfig;
import com.app.bookstore.dto.order.OrderRequestDto;
import com.app.bookstore.dto.order.OrderResponseDto;
import com.app.bookstore.model.Order;
import com.app.bookstore.model.OrderItem;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class, uses = OrderItem.class)
public interface OrderMapper {
    OrderResponseDto toDto(Order order);

    Order toOrder(OrderRequestDto requestDto);
}
