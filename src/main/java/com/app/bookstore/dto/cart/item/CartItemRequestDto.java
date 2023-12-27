package com.app.bookstore.dto.cart.item;

import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CartItemRequestDto {
    @Positive
    private Integer quantity;
}
