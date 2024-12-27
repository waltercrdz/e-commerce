package dev.waltercrdz.api.ecommerce.orders.infrastructure.in.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.springframework.http.MediaType;

import dev.waltercrdz.api.ecommerce.orders.domain.model.OrderStatus;
import dev.waltercrdz.api.ecommerce.orders.infrastructure.configuration.TestConfig;
import dev.waltercrdz.api.ecommerce.orders.infrastructure.utils.OrderCreationRequestMother;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
@Import(TestConfig.class)
public class OrderControllerTest {
    
    private static final String URI_CREATE_ORDER = "/orders";

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeAll
    void setup() {
        objectMapper = new ObjectMapper()
                        .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
                        .registerModule(new JavaTimeModule());
    }

    @Test //test_when_product_is_found_then_return_product
    void shouldCreateOrderSuccessfully_whenValidRequestProvided() throws Exception {
        final var request = OrderCreationRequestMother.createValid();

        mockMvc.perform(post(URI_CREATE_ORDER)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").isNotEmpty())
            .andExpect(jsonPath("$.order_status").value(OrderStatus.PENDING.name()));
    }
    
    @Test
    void shouldReturnBadRequest_whenCustomerIdIsInvalid() throws Exception {
        final var request = OrderCreationRequestMother.createWithInvalidCustomerId();

        mockMvc.perform(post(URI_CREATE_ORDER)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnBadRequest_whenProductQuantityIsZero() throws Exception {
        final var request = OrderCreationRequestMother.createWithProductOrderQuantityZero();

        mockMvc.perform(post(URI_CREATE_ORDER)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnBadRequest_whenProductListIsEmpty() throws Exception {
        final var request = OrderCreationRequestMother.createWithEmptyProductList();

        mockMvc.perform(post(URI_CREATE_ORDER)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isBadRequest());
        }
        
    @Test
    void shouldReturnConflict_whenProductIsOutOfStock() throws Exception {
        final var request = OrderCreationRequestMother.createWithProductOutOfStock();

        mockMvc.perform(post(URI_CREATE_ORDER)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isConflict());
    }

    @Test
    void shouldReturnBadRequest_whenProductDoesNotExist() throws Exception {
        final var request = OrderCreationRequestMother.createWithProductNotExist();

        mockMvc.perform(post(URI_CREATE_ORDER)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isBadRequest());
    }
}
