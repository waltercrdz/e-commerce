package dev.waltercrdz.api.ecommerce.orders.infrastructure.in.mapper;

import dev.waltercrdz.api.ecommerce.orders.domain.model.Order;
import dev.waltercrdz.api.ecommerce.orders.domain.model.OrderStatus;
import dev.waltercrdz.api.ecommerce.orders.domain.model.ProductOrder;
import dev.waltercrdz.api.ecommerce.orders.infrastructure.in.dto.OrderCreationRequest;
import dev.waltercrdz.api.ecommerce.orders.infrastructure.in.dto.OrderCreationResponse;

import java.util.UUID;

public class OrderMapper {

    public static Order toDomain(OrderCreationRequest source, UUID orderId) {
        return new Order.Builder()
                .id(orderId)
                .customerId(UUID.fromString(source.customerId()))
                .products(source.products().stream()
                        .map(product -> ProductOrder.of(
                                UUID.randomUUID(),
                                UUID.fromString(product.productId()),
                                product.quantity(),
                                product.price())
                        )
                        .toList())
                .status(OrderStatus.PENDING)
                .build();
    }

    public static OrderCreationResponse toResponse(Order source) {
        return new OrderCreationResponse(source.getId(), source.getStatus().name());
    }
}
