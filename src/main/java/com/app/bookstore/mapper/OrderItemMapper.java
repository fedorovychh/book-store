package com.app.bookstore.mapper;

import com.app.bookstore.config.MapperConfig;
import com.app.bookstore.dto.order.item.OrderItemResponseDto;
import com.app.bookstore.model.OrderItem;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface OrderItemMapper {
    OrderItemResponseDto toDto(OrderItem orderItem);
}
