package dev.waltercrdz.api.ecommerce.orders.infrastructure.out.persistence.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import dev.waltercrdz.api.ecommerce.orders.domain.model.OrderStatus;

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
    
    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private OrderStatus status;

    public OrderEntity() {}

    public OrderEntity(UUID id,
                       UUID customerId,
                       List<ProductOrderEntity> products,
                       OrderStatus status) {
        this.id = id;
        this.customerId = customerId;
        this.products = products;
        this.status = status;
    }
}
