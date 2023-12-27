package com.app.bookstore.service.shopping.cart;

import com.app.bookstore.dto.cart.item.CartItemRequestDto;
import com.app.bookstore.dto.shopping.cart.ShoppingCartResponseDto;
import com.app.bookstore.mapper.CartItemMapper;
import com.app.bookstore.mapper.ShoppingCartMapper;
import com.app.bookstore.model.CartItem;
import com.app.bookstore.model.ShoppingCart;
import com.app.bookstore.model.User;
import com.app.bookstore.repository.shopping.cart.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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
    public ShoppingCartResponseDto addToShoppingCart(Authentication authentication, CartItemRequestDto requestDto) {
        User user = (User) authentication.getPrincipal();
        ShoppingCart shoppingCart = shoppingCartRepository.findShoppingCartByUserId(user.getId());
        if (shoppingCart == null) {
            shoppingCart = createNewShoppingCart(user);
        }
        Set<CartItem> cartItems = shoppingCart.getCartItems();
        if (cartItems == null) {
            cartItems = new HashSet<>();
        }
        cartItems.add(cartItemMapper.toCartItem(requestDto));
        shoppingCart.setCartItems(cartItems);
        return shoppingCartMapper.toDto(shoppingCartRepository.save(shoppingCart));
    }

    private ShoppingCart createNewShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        return shoppingCart;
    }
}
