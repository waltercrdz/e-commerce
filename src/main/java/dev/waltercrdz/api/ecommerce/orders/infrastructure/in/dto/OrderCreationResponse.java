package dev.waltercrdz.api.ecommerce.orders.infrastructure.in.dto;

import java.util.UUID;

public record OrderCreationResponse(UUID id, String orderStatus) {}
