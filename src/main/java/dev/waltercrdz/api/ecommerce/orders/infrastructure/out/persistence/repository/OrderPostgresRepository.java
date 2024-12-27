package dev.waltercrdz.api.ecommerce.orders.infrastructure.out.persistence.repository;

import dev.waltercrdz.api.ecommerce.orders.infrastructure.out.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderPostgresRepository extends JpaRepository<OrderEntity, UUID> {

}
