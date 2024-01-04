package com.app.bookstore.mapper;

import com.app.bookstore.config.MapperConfig;
import com.app.bookstore.dto.order.item.OrderItemResponseDto;
import com.app.bookstore.model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface OrderItemMapper {
    @Mapping(target = "bookId", source = "book.id")
    OrderItemResponseDto toDto(OrderItem orderItem);
}
