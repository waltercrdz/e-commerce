package dev.waltercrdz.api.ecommerce.orders.application;

import dev.waltercrdz.api.ecommerce.orders.domain.exception.ProductNotFoundException;
import dev.waltercrdz.api.ecommerce.orders.domain.model.Order;
import dev.waltercrdz.api.ecommerce.orders.domain.repository.OrderCommandRepository;
import dev.waltercrdz.api.ecommerce.shared.domain.event.EventPublisher;
import dev.waltercrdz.api.ecommerce.orders.domain.event.OrderCreatedDomainEvent;
import org.springframework.stereotype.Service;

@Service
public class OrderCreator {

    private final OrderCommandRepository writer;
    private final EventPublisher eventPublisher;

    public OrderCreator(ProductFinder productFinder, OrderCommandRepository writer, EventPublisher eventPublisher) {
        this.writer = writer;
        this.eventPublisher = eventPublisher;
    }

    public void create(Order order) {
        this.writer.save(order);
        final var event = OrderCreatedDomainEvent.from(order);
        this.eventPublisher.publish(event);
    }
}
