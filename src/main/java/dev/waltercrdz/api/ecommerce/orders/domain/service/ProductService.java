package dev.waltercrdz.api.ecommerce.orders.domain.service;

import dev.waltercrdz.api.ecommerce.orders.domain.model.Product;

import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    Optional<Product> findById(UUID id);
}
