package dev.waltercrdz.api.ecommerce.orders.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductOrder {
    private final UUID product_id;
    private final Integer quantity;
    private final BigDecimal price;

    public static ProductOrder of(UUID product_id, Integer quantity, BigDecimal price) {
        return new ProductOrder(product_id, quantity, price);
    }

    private ProductOrder(UUID product_id, Integer quantity, BigDecimal price) {
        this.product_id = product_id;
        this.quantity = quantity;
        this.price = price;
    }

    public UUID getProductId() {
        return product_id;
    }
}
