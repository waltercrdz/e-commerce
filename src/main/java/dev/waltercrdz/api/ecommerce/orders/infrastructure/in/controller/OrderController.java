package dev.waltercrdz.api.ecommerce.orders.infrastructure.in.controller;

import dev.waltercrdz.api.ecommerce.orders.application.OrderCreator;
import dev.waltercrdz.api.ecommerce.orders.infrastructure.in.mapper.OrderMapper;
import jakarta.validation.Valid;
import dev.waltercrdz.api.ecommerce.orders.infrastructure.in.dto.OrderCreationRequest;
import dev.waltercrdz.api.ecommerce.orders.infrastructure.in.dto.OrderCreationResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderCreator orderCreator;

    public OrderController(OrderCreator createOrder) {
        this.orderCreator = createOrder;
    }

    @PostMapping
    public ResponseEntity<OrderCreationResponse> createOrder(@Valid @RequestBody OrderCreationRequest request) {
        final var orderToCreate = OrderMapper.toDomain(request, UUID.randomUUID());
        orderCreator.create(orderToCreate);
        final var response = OrderMapper.toResponse(orderToCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
