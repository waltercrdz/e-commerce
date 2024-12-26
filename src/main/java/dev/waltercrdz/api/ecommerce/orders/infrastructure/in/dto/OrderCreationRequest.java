package dev.waltercrdz.api.ecommerce.orders.infrastructure.in.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record OrderCreationRequest(
    @NotBlank String customerId, 
    @NotEmpty List<@Valid ProductOrderRequest> products) {}
