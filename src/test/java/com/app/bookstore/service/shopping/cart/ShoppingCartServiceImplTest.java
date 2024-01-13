package com.app.bookstore.service.shopping.cart;

import static org.mockito.Mockito.when;

import com.app.bookstore.dto.shopping.cart.ShoppingCartResponseDto;
import com.app.bookstore.mapper.ShoppingCartMapper;
import com.app.bookstore.model.ShoppingCart;
import com.app.bookstore.model.User;
import com.app.bookstore.repository.shopping.cart.ShoppingCartRepository;
import java.util.HashSet;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ShoppingCartServiceImplTest {
    private static ShoppingCart shoppingCart;
    private static ShoppingCartResponseDto shoppingCartResponseDto;
    private static User user;
    @Mock
    private static ShoppingCartRepository shoppingCartRepository;
    @Mock
    private static ShoppingCartMapper shoppingCartMapper;
    @InjectMocks
    private static ShoppingCartServiceImpl shoppingCartService;

    @BeforeAll
    static void beforeAll() {
        user = new User();
        user.setId(4L);

        shoppingCart = new ShoppingCart();
        shoppingCart.setId(8L);
        shoppingCart.setUser(user);
        shoppingCart.setCartItems(new HashSet<>());

        shoppingCartResponseDto = new ShoppingCartResponseDto();
        shoppingCartResponseDto.setId(8L);
        shoppingCartResponseDto.setUserId(user.getId());
        shoppingCartResponseDto.setCartItems(new HashSet<>());
    }

    @Test
    @DisplayName("Find shopping cart by user id")
    void findByUserId_ValidData_ReturnsShoppingCartResponseDto() {
        when(shoppingCartRepository.findByUserId(user.getId()))
                .thenReturn(Optional.ofNullable(shoppingCart));
        when(shoppingCartMapper.toDto(shoppingCart)).thenReturn(shoppingCartResponseDto);
        ShoppingCartResponseDto expected = shoppingCartResponseDto;
        ShoppingCartResponseDto actual = shoppingCartService.findByUserId(user.getId());
        Assertions.assertEquals(expected, actual,
                "Expected shopping cart response DTO should be: " + expected
                + " but was: " + actual);
    }
}
