package dev.waltercrdz.api.ecommerce.orders.infrastructure.in.dto;

import java.math.BigDecimal;

public record ProductOrderRequest(String productId, Integer quantity, BigDecimal price) {
}
