package com.app.bookstore.service.cart.item;

import com.app.bookstore.dto.cart.item.CartItemResponseDto;
import com.app.bookstore.dto.shopping.cart.ShoppingCartRequestDto;
import com.app.bookstore.exception.EntityNotFoundException;
import com.app.bookstore.mapper.CartItemMapper;
import com.app.bookstore.model.CartItem;
import com.app.bookstore.model.ShoppingCart;
import com.app.bookstore.repository.book.BookRepository;
import com.app.bookstore.repository.cart.item.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;
    private final CartItemMapper cartItemMapper;
    private final BookRepository bookRepository;

    @Override
    public CartItemResponseDto updateCartItemById(Long cartItemId, int quantity) {
        CartItem cartItemById = getById(cartItemId);
        cartItemById.setQuantity(quantity);
        return cartItemMapper.toDto(cartItemRepository.save(cartItemById));
    }

    @Override
    public void deleteCartItem(Long cartItemId) {
        cartItemRepository.delete(parseCartItem(cartItemId));
    }

    @Override
    public CartItem addCartItem(ShoppingCart shoppingCart, ShoppingCartRequestDto requestDto) {
        CartItem cartItem = cartItemMapper.toCartItem(requestDto);
        cartItem.setShoppingCart(shoppingCart);
        Long bookId = requestDto.getBookId();
        cartItem.setBook(bookRepository.findById(bookId).orElseThrow(
                () -> new EntityNotFoundException("Can't find book by id: " + bookId)
        ));
        return cartItemRepository.save(cartItem);
    }

    private CartItem getById(Long cartItemId) {
        return cartItemRepository.findById(cartItemId).orElseThrow(
                () -> new EntityNotFoundException("Can't find item by id: " + cartItemId)
        );
    }
}
