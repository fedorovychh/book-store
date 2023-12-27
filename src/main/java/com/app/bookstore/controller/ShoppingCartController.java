package com.app.bookstore.controller;

import com.app.bookstore.dto.cart.item.CartItemRequestDto;
import com.app.bookstore.dto.category.CategoryResponseDto;
import com.app.bookstore.dto.category.CreateCategoryRequestDto;
import com.app.bookstore.dto.shopping.cart.ShoppingCartResponseDto;
import com.app.bookstore.mapper.ShoppingCartMapper;
import com.app.bookstore.model.User;
import com.app.bookstore.service.shopping.cart.ShoppingCartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/cart")
@Tag(name = "Shopping cart management", description = "Endpoints for shopping cart")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping
    @Operation(summary = "Get shopping cart", description = "Get all shopping cart details")
    public ShoppingCartResponseDto getShoppingCart(Authentication authentication) {
        Long userId = getUserId(authentication);
        return shoppingCartService.findShoppingCartByUserId(userId);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping
    @Operation(summary = "Add book to shopping cart", description = "Add book to shopping cart")
    public ShoppingCartResponseDto addToShoppingCart(Authentication authentication,
                                 @RequestBody @Valid CartItemRequestDto requestDto) {
        Long userId = getUserId(authentication);
        return shoppingCartService.addToShoppingCart(userId, requestDto);
    }

    private Long getUserId(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return user.getId();
    }
}
