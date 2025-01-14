package dev.waltercrdz.api.ecommerce.products.infrastructure.in.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponse(
    UUID id,
    String name,
    String description,
    BigDecimal price,
    Integer stock) {
}
