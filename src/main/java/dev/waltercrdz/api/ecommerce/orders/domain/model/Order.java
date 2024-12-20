package dev.waltercrdz.api.ecommerce.orders.domain.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Order {
    private final UUID id;
    private final UUID customerId;
    private final List<ProductOrder> products;
    private final BigDecimal total;
    private final OrderStatus status;

    private Order(Builder builder) {
        this.id = builder.id;
        this.customerId = builder.customerId;
        this.products = builder.products;
        this.total = builder.total;
        this.status = builder.status;
    }

    public UUID getId() {
        return id;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public List<ProductOrder> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public BigDecimal getTotal() {
        return total;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public static class Builder {
        private UUID id;
        private UUID customerId;
        private List<ProductOrder> products;
        private BigDecimal total;
        private OrderStatus status;

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder customerId(UUID customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder products(List<ProductOrder> products) {
            this.products = products;
            return this;
        }

        public Builder total(BigDecimal total) {
            this.total = total;
            return this;
        }

        public Builder status(OrderStatus status) {
            this.status = status;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
