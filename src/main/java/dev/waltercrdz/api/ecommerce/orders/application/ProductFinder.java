package dev.waltercrdz.api.ecommerce.orders.application;

import dev.waltercrdz.api.ecommerce.orders.domain.model.Product;
import dev.waltercrdz.api.ecommerce.orders.domain.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductFinder {

    private final ProductService productService;

    public ProductFinder(ProductService productService) {
        this.productService = productService;
    }

    public Optional<Product> findById(UUID product_id) {
        return this.productService.findById(product_id);
    }
}
