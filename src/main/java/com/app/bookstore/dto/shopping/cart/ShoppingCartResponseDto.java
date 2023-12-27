package com.app.bookstore.dto.shopping.cart;

import com.app.bookstore.dto.cart.item.CartItemResponseDto;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class ShoppingCartResponseDto {
    private Long id;
    private Long userId;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<CartItemResponseDto> cartItems;
}
