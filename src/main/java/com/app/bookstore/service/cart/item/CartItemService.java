package com.app.bookstore.service.cart.item;

import com.app.bookstore.dto.cart.item.CartItemResponseDto;
import com.app.bookstore.dto.shopping.cart.ShoppingCartRequestDto;
import com.app.bookstore.model.CartItem;
import com.app.bookstore.model.ShoppingCart;

public interface CartItemService {

    CartItemResponseDto updateCartItemById(Long cartItemId, int quantity);

    void deleteCartItem(Long cartItemId);

    CartItem addCartItem(ShoppingCart shoppingCart, ShoppingCartRequestDto requestDto);
}
