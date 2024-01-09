package com.app.bookstore.service.shopping.cart;

import com.app.bookstore.dto.cart.item.PutCartItemRequestDto;
import com.app.bookstore.dto.shopping.cart.ShoppingCartRequestDto;
import com.app.bookstore.dto.shopping.cart.ShoppingCartResponseDto;
import com.app.bookstore.exception.EntityNotFoundException;
import com.app.bookstore.mapper.ShoppingCartMapper;
import com.app.bookstore.model.CartItem;
import com.app.bookstore.model.ShoppingCart;
import com.app.bookstore.model.User;
import com.app.bookstore.repository.shopping.cart.ShoppingCartRepository;
import com.app.bookstore.service.cart.item.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final CartItemService cartItemService;
    private final ShoppingCartRepository shoppingCartRepository;
    private final ShoppingCartMapper shoppingCartMapper;

    @Override
    public ShoppingCartResponseDto findByUserId(Long id) {
        return shoppingCartMapper.toDto(shoppingCartRepository
                .findByUserId(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Can't find"
                                + " shopping cart by user's id: " + id)
                ));
    }

    @Override
    public void createShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCartResponseDto addToShoppingCart(Long userId,
                                                     ShoppingCartRequestDto requestDto) {
        ShoppingCart shoppingCart = shoppingCartRepository.findByUserId(userId)
                .orElseThrow(
                        () -> new EntityNotFoundException("Can't find"
                                + " shopping cart by user's id: " + userId)
                );
        CartItem cartItem = cartItemService.addCartItem(shoppingCart, requestDto);
        shoppingCart.getCartItems().add(cartItem);
        return shoppingCartMapper.toDto(shoppingCart);
    }

    @Override
    public ShoppingCartResponseDto updateByCartId(
            Long userId,
            Long id,
            PutCartItemRequestDto requestDto
    ) {
        cartItemService.updateById(id, requestDto.getQuantity());
        ShoppingCart shoppingCart = shoppingCartRepository.findByUserId(userId)
                .orElseThrow(
                        () -> new EntityNotFoundException("Can't find"
                                + " shopping cart by user's id: " + userId)
                );
        return shoppingCartMapper.toDto(shoppingCart);
    }
}
