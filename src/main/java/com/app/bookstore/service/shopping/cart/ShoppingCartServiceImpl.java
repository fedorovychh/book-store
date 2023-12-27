package com.app.bookstore.service.shopping.cart;

import com.app.bookstore.dto.cart.item.CartItemRequestDto;
import com.app.bookstore.dto.shopping.cart.ShoppingCartResponseDto;
import com.app.bookstore.mapper.CartItemMapper;
import com.app.bookstore.mapper.ShoppingCartMapper;
import com.app.bookstore.model.CartItem;
import com.app.bookstore.model.ShoppingCart;
import com.app.bookstore.repository.shopping.cart.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final ShoppingCartMapper shoppingCartMapper;
    private final CartItemMapper cartItemMapper;

    @Override
    public ShoppingCartResponseDto findShoppingCartByUserId(Long userId) {
        return shoppingCartMapper.toDto(shoppingCartRepository.findShoppingCartByUserId(userId));
    }

    @Override
    public ShoppingCartResponseDto addToShoppingCart(Long userId, CartItemRequestDto requestDto) {
        ShoppingCart shoppingCartByUserId = shoppingCartRepository.findShoppingCartByUserId(userId);
        if (shoppingCartByUserId != null) {
            Set<CartItem> cartItems = shoppingCartByUserId.getCartItems();
            cartItems.add(cartItemMapper.toCartItem(requestDto));
            shoppingCartByUserId.setCartItems(cartItems);
        }


        return null;
    }
}
