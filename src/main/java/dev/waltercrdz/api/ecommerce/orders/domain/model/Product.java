package dev.waltercrdz.api.ecommerce.orders.domain.model;

import java.util.UUID;

public class Product {

    private final UUID id;
    private final Integer stock;

    public static Product of(UUID id, Integer stock) {
        return new Product(id, stock);
    }

    private Product(UUID id, Integer stock) {
        this.id = id;
        this.stock = stock;
    }

    public boolean hasStock(Integer quantity) {
        return this.stock >= quantity;
    }
}
