package dev.waltercrdz.api.ecommerce.orders.infrastructure.in.dto;

import java.util.List;

public record OrderCreationRequest(String customerId, List<ProductOrderRequest> products) {}
