package com.app.bookstore.service.cart.item;

import com.app.bookstore.dto.cart.item.CartItemResponseDto;
import com.app.bookstore.model.ShoppingCart;

public interface CartItemService {

    CartItemResponseDto updateCartItemById(Long cartItemId, int quantity);

    void deleteCartItem(Long cartItemId);
}
