package dev.waltercrdz.api.ecommerce.orders.application;

import dev.waltercrdz.api.ecommerce.orders.domain.model.Product;
import dev.waltercrdz.api.ecommerce.orders.domain.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductFinder {

    public Optional<Product> findById(UUID product_id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
