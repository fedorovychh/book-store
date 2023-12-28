package com.app.bookstore.service.shopping.cart;

import com.app.bookstore.dto.cart.item.PutCartItemRequestDto;
import com.app.bookstore.dto.shopping.cart.ShoppingCartRequestDto;
import com.app.bookstore.dto.shopping.cart.ShoppingCartResponseDto;
import com.app.bookstore.model.User;
import org.springframework.security.core.Authentication;

public interface ShoppingCartService {
    ShoppingCartResponseDto findShoppingCartByUserId(Long userId);

    void createShoppingCart(User user);

    ShoppingCartResponseDto addToShoppingCart(Authentication authentication,
                                              ShoppingCartRequestDto requestDto);

    ShoppingCartResponseDto updateShoppingCartByCartId(
            Authentication authentication,
            Long cartItemId,
            PutCartItemRequestDto requestDto
    );
}
