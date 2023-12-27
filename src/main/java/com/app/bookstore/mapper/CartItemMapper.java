package com.app.bookstore.mapper;

import com.app.bookstore.config.MapperConfig;
import com.app.bookstore.dto.cart.item.CartItemRequestDto;
import com.app.bookstore.dto.cart.item.CartItemResponseDto;
import com.app.bookstore.model.CartItem;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface CartItemMapper {
    CartItemResponseDto toDto(CartItem cartItem);

    CartItem toCartItem(CartItemRequestDto requestDto);
}
