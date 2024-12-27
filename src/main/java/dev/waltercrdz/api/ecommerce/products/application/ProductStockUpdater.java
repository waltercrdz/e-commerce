package dev.waltercrdz.api.ecommerce.products.application;

import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.waltercrdz.api.ecommerce.products.domain.repository.ProductCommandRepository;
import dev.waltercrdz.api.ecommerce.shared.domain.exception.ProductNotFoundException;

@Service
public class ProductStockUpdater {

    private final ProductCommandRepository writer;

    public ProductStockUpdater(ProductCommandRepository writer) {
        this.writer = writer;
    }

    public void updateStock(UUID productId, Integer quantity) {
        final var product = this.writer.findById(productId)
                                    .orElseThrow(() -> new ProductNotFoundException("Product not found", productId));
        product.decreaseStock(quantity);
        this.writer.save(product);
    }
}
