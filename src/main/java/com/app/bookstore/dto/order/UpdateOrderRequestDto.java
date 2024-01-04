package com.app.bookstore.dto.order;

import com.app.bookstore.model.Order;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateOrderRequestDto {
    @NotNull
    private Order.Status status;
}
