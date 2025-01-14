package dev.waltercrdz.api.ecommerce.products.application;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.waltercrdz.api.ecommerce.products.domain.model.Product;
import dev.waltercrdz.api.ecommerce.products.domain.repository.ProductQueryRepository;
import dev.waltercrdz.api.ecommerce.shared.domain.exception.ProductNotFoundException;

@Service
public class ProductFinder {

    private final ProductQueryRepository reader;

    public ProductFinder(ProductQueryRepository reader) {
        this.reader = reader;
    }

    public Product find(UUID id) {
        return reader.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found", id));
    }

    public List<Product> findAll() {
        return reader.findAll();
    }
}
