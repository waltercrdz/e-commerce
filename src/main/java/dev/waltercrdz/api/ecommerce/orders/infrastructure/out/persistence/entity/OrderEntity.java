package dev.waltercrdz.api.ecommerce.orders.infrastructure.out.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    private UUID id;

    @Column(name = "customer_id")
    private UUID customerId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id", nullable = false)
    private List<ProductOrderEntity> products;
    private BigDecimal total;
    private String status;

    public OrderEntity() {}

    public OrderEntity(UUID id,
                       UUID customerId,
                       List<ProductOrderEntity> products,
                       BigDecimal total,
                       String status) {
        this.id = id;
        this.customerId = customerId;
        this.products = products;
        this.total = total;
        this.status = status;
    }
}
