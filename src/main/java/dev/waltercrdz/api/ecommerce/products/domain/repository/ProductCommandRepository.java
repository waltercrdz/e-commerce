package dev.waltercrdz.api.ecommerce.products.domain.repository;

import java.util.Optional;
import java.util.UUID;

import dev.waltercrdz.api.ecommerce.products.domain.model.Product;

public interface ProductCommandRepository {

    void save(Product product);

    Optional<Product> findById(UUID id);
}
