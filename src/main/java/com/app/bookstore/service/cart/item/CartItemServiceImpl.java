package com.app.bookstore.service.cart.item;

import com.app.bookstore.dto.cart.item.CartItemResponseDto;
import com.app.bookstore.exception.EntityNotFoundException;
import com.app.bookstore.mapper.CartItemMapper;
import com.app.bookstore.model.CartItem;
import com.app.bookstore.model.ShoppingCart;
import com.app.bookstore.repository.cart.item.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;
    private final CartItemMapper cartItemMapper;

    @Override
    public CartItemResponseDto updateCartItemById(Long cartItemId, int quantity) {
        CartItem cartItemById = parseCartItem(cartItemId);
        cartItemById.setQuantity(quantity);
        return cartItemMapper.toDto(cartItemRepository.save(cartItemById));
    }

    @Override
    public void deleteCartItem(Long cartItemId) {
        cartItemRepository.delete(parseCartItem(cartItemId));
    }

    private CartItem parseCartItem(Long cartItemId) {
        return cartItemRepository.findById(cartItemId).orElseThrow(
                () -> new EntityNotFoundException("Can't find item by id: " + cartItemId)
        );
    }
}
