package com.app.bookstore.controller;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.app.bookstore.dto.book.BookDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {
    private static final String URL_BOOKS = "/books";
    private static final int DEFAULT_AMOUNT_IN_BOOKS_TABLE = 7;
    private static MockMvc mockMvc;
    private static BookDto bookDto;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeAll
    static void beforeAll(
            @Autowired WebApplicationContext applicationContext
    ) {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(applicationContext)
                .apply(springSecurity())
                .build();

        bookDto = new BookDto();
        bookDto.setId(1L);
        bookDto.setTitle("Test Book");
        bookDto.setAuthor("Test Author");
        bookDto.setIsbn("9783161484100");
        bookDto.setPrice(BigDecimal.valueOf(17.50));
        bookDto.setDescription("Description for test book");
        bookDto.setCategoryIds(Set.of(1L));
    }

    @WithMockUser(username = "user")
    @Test
    @DisplayName("Get all books")
    void getAll_ValidRequest_Success() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get(URL_BOOKS)).andReturn();
        List<BookDto> actual = objectMapper
                .readValue(mvcResult.getResponse().getContentAsString(),
                    new TypeReference<>() {
                    });
        Assertions.assertEquals(DEFAULT_AMOUNT_IN_BOOKS_TABLE, actual.size());
    }
}
