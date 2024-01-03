package com.app.bookstore.service.order;

import com.app.bookstore.dto.order.OrderRequestDto;
import com.app.bookstore.dto.order.OrderResponseDto;
import com.app.bookstore.dto.order.UpdateOrderRequestDto;
import com.app.bookstore.exception.EntityNotFoundException;
import com.app.bookstore.mapper.OrderMapper;
import com.app.bookstore.model.CartItem;
import com.app.bookstore.model.Order;
import com.app.bookstore.model.OrderItem;
import com.app.bookstore.model.ShoppingCart;
import com.app.bookstore.model.User;
import com.app.bookstore.repository.cart.item.CartItemRepository;
import com.app.bookstore.repository.order.OrderRepository;
import com.app.bookstore.repository.order.item.OrderItemRepository;
import com.app.bookstore.repository.shopping.cart.ShoppingCartRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderMapper orderMapper;
    private final ShoppingCartRepository shoppingCartRepository;
    private final CartItemRepository cartItemRepository;

    @Override
    @Transactional
    public OrderResponseDto placeOrder(User user, OrderRequestDto requestDto) {
        ShoppingCart shoppingCart = shoppingCartRepository.findByUserId(user.getId()).orElseThrow(
                () -> new EntityNotFoundException("Can't find cart by user id: " + user.getId())
        );
        Order order = createOrder(user, shoppingCart, requestDto);
        Order savedOrder = orderRepository.save(order);
        Set<OrderItem> orderItems = getOrderItems(shoppingCart);
        savedOrder.setOrderItems(orderItems); // is not correct
        orderItems.forEach(oi -> oi.setOrder(order));
        orderItemRepository.saveAll(orderItems);
        cartItemRepository.deleteAll(shoppingCart.getCartItems());
        return orderMapper.toDto(savedOrder);
    }

    @Override
    public List<OrderResponseDto> getAll(Long id) {
        List<Order> orderList = orderRepository.findAllById(id);
        return orderList.stream()
                .map(orderMapper::toDto)
                .toList();
    }

    @Override
    public OrderResponseDto updateStatus(Long id, UpdateOrderRequestDto requestDto) {
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find order by id: " + id)
        );
        order.setStatus(requestDto.getStatus());
        return orderMapper.toDto(orderRepository.save(order));
    }

    private Order createOrder(User user, ShoppingCart shoppingCart, OrderRequestDto requestDto) {
        Order order = new Order();
        order.setUser(user);
        order.setStatus(Order.Status.PROCESSING);
        order.setShippingAddress(requestDto.getShippingAddress());
        order.setTotal(
                shoppingCart.getCartItems().stream()
                        .map(ci -> ci.getBook()
                                .getPrice()
                                .multiply(BigDecimal.valueOf(ci.getQuantity())))
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
        );
        order.setOrderDate(LocalDateTime.now());
        return order;
    }

    private Set<OrderItem> getOrderItems(ShoppingCart shoppingCart) {
        Set<CartItem> cartItems = shoppingCart.getCartItems();
        return cartItems.stream()
                .map(this::convertToOrderItem)
                .collect(Collectors.toSet());

    }

    private OrderItem convertToOrderItem(CartItem cartItem) {
        OrderItem orderItem = new OrderItem();
        orderItem.setBook(cartItem.getBook());
        orderItem.setQuantity(cartItem.getQuantity());
        orderItem.setPrice(cartItem.getBook().getPrice());
        return orderItem;
    }
}
