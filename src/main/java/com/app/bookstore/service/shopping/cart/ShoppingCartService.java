package com.app.bookstore.service.shopping.cart;

import com.app.bookstore.dto.cart.item.PutCartItemRequestDto;
import com.app.bookstore.dto.shopping.cart.ShoppingCartRequestDto;
import com.app.bookstore.dto.shopping.cart.ShoppingCartResponseDto;
import com.app.bookstore.model.User;

public interface ShoppingCartService {
    ShoppingCartResponseDto findByUserId(Long id);

    void createShoppingCart(User user);

    ShoppingCartResponseDto addToShoppingCart(Long userId,
                                              ShoppingCartRequestDto requestDto);

    ShoppingCartResponseDto updateByCartId(
            Long userId,
            Long id,
            PutCartItemRequestDto requestDto
    );
}
