package dev.waltercrdz.api.ecommerce.products.domain.repository;

import dev.waltercrdz.api.ecommerce.products.domain.model.Product;

public interface ProductCommandRepository {

    void save(Product product);
}