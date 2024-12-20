package dev.waltercrdz.api.ecommerce.orders.infrastructure.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "product_orders")
public class ProductOrderEntity {
    @Id
    private UUID id;
    @Column(name = "product_id")
    private UUID productId;
    private Integer quantity;
    private BigDecimal price;

    public ProductOrderEntity() {}

    public ProductOrderEntity(UUID product_id,
                              Integer quantity,
                              BigDecimal price) {
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
