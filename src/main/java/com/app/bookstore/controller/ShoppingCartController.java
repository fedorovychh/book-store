package com.app.bookstore.controller;

import com.app.bookstore.dto.cart.item.CartItemRequestDto;
import com.app.bookstore.dto.category.CategoryResponseDto;
import com.app.bookstore.dto.category.CreateCategoryRequestDto;
import com.app.bookstore.dto.shopping.cart.ShoppingCartRequestDto;
import com.app.bookstore.dto.shopping.cart.ShoppingCartResponseDto;
import com.app.bookstore.mapper.ShoppingCartMapper;
import com.app.bookstore.model.User;
import com.app.bookstore.service.cart.item.CartItemService;
import com.app.bookstore.service.shopping.cart.ShoppingCartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/cart")
@Tag(name = "Shopping cart management", description = "Endpoints for shopping cart")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final CartItemService cartItemService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping
    @Operation(summary = "Get shopping cart", description = "Get all shopping cart details")
    public ShoppingCartResponseDto getShoppingCart(Authentication authentication) {
        return shoppingCartService.findShoppingCartByUserId(getUserId(authentication));
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping
    @Operation(summary = "Add book to shopping cart", description = "Add book to shopping cart")
    public ShoppingCartResponseDto addToShoppingCart(Authentication authentication,
                                 @RequestBody @Valid ShoppingCartRequestDto requestDto) {
        return shoppingCartService.addToShoppingCart(authentication, requestDto);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("/cart-items/{cartItemId}")
    @Operation(
            summary = "Update books quantity",
            description = "Update quantity of a book in the shopping cart"
    )
    public ShoppingCartResponseDto updateById(
            Authentication authentication,
            @PathVariable Long cartItemId,
            @RequestBody @Valid CartItemRequestDto requestDto
    ) {
        return shoppingCartService
                .updateShoppingCartByCartId(authentication, cartItemId, requestDto);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @DeleteMapping("/cart-items/{cartItemId}")
    @Operation(
            summary = "Delete book from shopping cart",
            description = "Delete book from shopping cart by id"
    )
    public void deleteItemFromShoppingCart(@PathVariable Long cartItemId) {
        cartItemService.deleteCartItem(cartItemId);
    }

    private Long getUserId(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return user.getId();
    }
}
