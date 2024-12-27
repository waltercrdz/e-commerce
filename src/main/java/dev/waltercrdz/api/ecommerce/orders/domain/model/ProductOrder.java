package dev.waltercrdz.api.ecommerce.orders.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductOrder {

    private final UUID id;
    private final UUID productId;
    private final Integer quantity;
    private final BigDecimal price;

    public static ProductOrder of(UUID id, UUID product_id, Integer quantity, BigDecimal price) {
        return new ProductOrder(id, product_id, quantity, price);
    }

    private ProductOrder(UUID id, UUID product_id, Integer quantity, BigDecimal price) {
        this.id = id;
        this.productId = product_id;
        this.quantity = quantity;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public UUID getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
