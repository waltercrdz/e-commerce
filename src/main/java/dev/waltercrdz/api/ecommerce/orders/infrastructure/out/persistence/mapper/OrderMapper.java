package dev.waltercrdz.api.ecommerce.orders.infrastructure.out.persistence.mapper;

import dev.waltercrdz.api.ecommerce.orders.domain.model.Order;
import dev.waltercrdz.api.ecommerce.orders.infrastructure.out.persistence.entity.OrderEntity;
import dev.waltercrdz.api.ecommerce.orders.infrastructure.out.persistence.entity.ProductOrderEntity;

public class OrderMapper {

    public static OrderEntity toEntity(Order source) {
        final var products = source.getProducts().stream()
                .map(product -> new ProductOrderEntity(
                        product.getId(),
                        product.getQuantity(),
                        product.getPrice()
                ))
                .toList();
        return new OrderEntity(
                source.getId(),
                source.getCustomerId(),
                products,
                source.getTotal(),
                source.getStatus().getValue()
        );
    }
}
