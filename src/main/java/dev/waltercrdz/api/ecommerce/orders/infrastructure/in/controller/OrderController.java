package dev.waltercrdz.api.ecommerce.orders.infrastructure.in.controller;

import dev.waltercrdz.api.ecommerce.orders.application.OrderCreator;
import dev.waltercrdz.api.ecommerce.orders.infrastructure.in.mapper.OrderMapper;
import dev.waltercrdz.api.ecommerce.orders.infrastructure.in.dto.OrderCreationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderCreator createOrder;
    public OrderController(OrderCreator createOrder) {
        this.createOrder = createOrder;
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody OrderCreationRequest request) {
        final var orderToCreate = OrderMapper.from(request, UUID.randomUUID());
        this.createOrder.create(orderToCreate);
        return ResponseEntity.ok().build();
    }
}
