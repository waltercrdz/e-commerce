package dev.waltercrdz.api.ecommerce.orders.infrastructure.in.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductOrderRequest(
    @NotBlank String productId, 
    @NotNull @Min(1) Integer quantity, 
    @NotNull @Min(0) BigDecimal price) {}
