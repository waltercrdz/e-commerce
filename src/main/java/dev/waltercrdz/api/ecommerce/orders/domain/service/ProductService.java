package dev.waltercrdz.api.ecommerce.orders.domain.service;

import java.util.Optional;
import java.util.UUID;

import dev.waltercrdz.api.ecommerce.products.domain.model.Product;

public interface ProductService {
    Optional<Product> findById(UUID id);
}
