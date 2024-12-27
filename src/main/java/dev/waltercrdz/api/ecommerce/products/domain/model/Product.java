package dev.waltercrdz.api.ecommerce.products.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

import dev.waltercrdz.api.ecommerce.shared.domain.exception.NotEnoughStockException;

public class Product {

    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;

    public static Product of(UUID id, String name, String description, BigDecimal price, Integer stock) {
        return new Product(id, name, description, price, stock);
    }

    private Product(UUID id, String name, String description, BigDecimal price, Integer stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public boolean hasStock(Integer quantity) {
        return this.stock >= quantity;
    }

    public void decreaseStock(Integer quantity) {
        if (!hasStock(quantity)) {
            throw new NotEnoughStockException("Insufficient stock for quantity: " + quantity, this.id);
        }
        this.stock = this.stock - quantity;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }
}
