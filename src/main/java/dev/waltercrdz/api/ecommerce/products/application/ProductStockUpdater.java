package dev.waltercrdz.api.ecommerce.products.application;

import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.waltercrdz.api.ecommerce.products.domain.repository.ProductCommandRepository;

@Service
public class ProductStockUpdater {

    private final ProductFinder finder;
    private final ProductCommandRepository writer;

    public ProductStockUpdater(ProductFinder finder, ProductCommandRepository writer) {
        this.finder = finder;
        this.writer = writer;
    }

    public void updateStock(UUID productId, Integer quantity) {
        final var product = finder.find(productId);
        product.decreaseStock(quantity);
        this.writer.save(product);
    }
}
