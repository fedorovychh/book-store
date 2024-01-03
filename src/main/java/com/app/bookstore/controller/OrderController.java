package com.app.bookstore.controller;

import com.app.bookstore.dto.order.OrderRequestDto;
import com.app.bookstore.dto.order.OrderResponseDto;
import com.app.bookstore.model.Order;
import com.app.bookstore.model.User;
import com.app.bookstore.service.order.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/orders")
@Tag(name = "Order management", description = "Endpoints for managing orders")
public class OrderController {
    private final OrderService orderService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping
    @Operation(summary = "Place order", description = "Place order")
    public OrderResponseDto placeOrder(@RequestBody OrderRequestDto requestDto) {
        return orderService.placeOrder(requestDto);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping
    @Operation(summary = "Get all orders", description = "Return all orders")
    public List<Order> getAll(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return orderService.getAll(user.getId());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PatchMapping("/{id}")
    @Operation(summary = "Change order status", description = "Change order status")
    public OrderResponseDto updateStatus(@PathVariable Long id, @RequestBody Object o) {
        return  null;
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/{id}/items")
    @Operation(
            summary = "Get all items by order id",
            description = "Retrieve all OrderItems for a specific order"
    )
    public Object getAllById(@PathVariable Long id) {
        return null;
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/{id}/items/{itemId}")
    public Object getItemById(@PathVariable Long id, @PathVariable Long itemId) {
        return null;
    }
}
