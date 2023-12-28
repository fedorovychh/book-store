package com.app.bookstore.service.cart.item;

import com.app.bookstore.dto.cart.item.CartItemResponseDto;
import com.app.bookstore.model.ShoppingCart;

public interface CartItemService {

    CartItemResponseDto updateCartItemById(ShoppingCart shoppingCart, Long cartItemId, int quantity);
}
