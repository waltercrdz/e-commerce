package dev.waltercrdz.api.ecommerce.orders.infrastructure.out.persistence.repository;

import dev.waltercrdz.api.ecommerce.orders.domain.model.Order;
import dev.waltercrdz.api.ecommerce.orders.domain.repository.OrderCommandRepository;
import dev.waltercrdz.api.ecommerce.orders.infrastructure.out.persistence.mapper.OrderMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryDefault implements OrderCommandRepository {

    private final OrderPostgresRepository orderPostgresRepository;

    public OrderRepositoryDefault(OrderPostgresRepository orderPostgresRepository) {
        this.orderPostgresRepository = orderPostgresRepository;
    }

    @Override
    public void save(Order order) {
        final var orderEntity = OrderMapper.toEntity(order);
        orderPostgresRepository.save(orderEntity);
    }

}
