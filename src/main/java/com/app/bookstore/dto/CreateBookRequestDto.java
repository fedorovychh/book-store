package com.app.bookstore.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class CreateBookRequestDto {
    @NotNull
    @Size(min = 4, max = 20, message = "Title length should be between 4 and 20")
    private String title;
    @NotNull
    private String author;
    @NotNull
    @Size(min = 13, max = 13, message = "ISBN length should be 13")
    private String isbn;
    @NotNull
    @Positive
    private BigDecimal price;
    private String description;
    private String coverImage;
}
