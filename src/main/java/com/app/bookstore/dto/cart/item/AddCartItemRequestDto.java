package com.app.bookstore.dto.cart.item;

import lombok.Data;

@Data
public class AddCartItemRequestDto {
    private Long bookId;
    private Integer quantity;
}
