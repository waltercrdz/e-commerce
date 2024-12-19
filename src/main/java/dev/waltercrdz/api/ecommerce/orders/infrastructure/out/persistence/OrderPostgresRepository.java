package dev.waltercrdz.api.ecommerce.orders.infrastructure.out.persistence;

import dev.waltercrdz.api.ecommerce.orders.domain.model.Order;
import dev.waltercrdz.api.ecommerce.orders.domain.repository.OrderCommandRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderPostgresRepository extends JpaRepository<Order, UUID>, OrderCommandRepository {

}
