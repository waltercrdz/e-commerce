package dev.waltercrdz.api.ecommerce.orders.domain.repository;

import dev.waltercrdz.api.ecommerce.orders.domain.model.Order;

public interface OrderCommandRepository {

    Order save(Order order);
}
