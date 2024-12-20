package dev.waltercrdz.api.ecommerce.orders.infrastructure.in.mapper;

import dev.waltercrdz.api.ecommerce.orders.domain.model.Order;
import dev.waltercrdz.api.ecommerce.orders.domain.model.ProductOrder;
import dev.waltercrdz.api.ecommerce.orders.infrastructure.in.dto.OrderCreationRequest;

import java.util.UUID;

public class OrderMapper {

    public static Order from(OrderCreationRequest source, UUID orderId) {
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
                .build();
    }
}
