package com.app.bookstore.service.shopping.cart;

import com.app.bookstore.dto.cart.item.CartItemRequestDto;
import com.app.bookstore.dto.shopping.cart.ShoppingCartResponseDto;
import org.springframework.security.core.Authentication;

public interface ShoppingCartService {
    ShoppingCartResponseDto findShoppingCartByUserId(Long userId);

    ShoppingCartResponseDto addToShoppingCart(Authentication authentication, CartItemRequestDto requestDto);
}
