package dev.waltercrdz.api.ecommerce.orders.application;

import static com.google.common.base.Preconditions.checkArgument;

import dev.waltercrdz.api.ecommerce.orders.domain.model.Order;
import dev.waltercrdz.api.ecommerce.orders.domain.repository.OrderCommandRepository;
import dev.waltercrdz.api.ecommerce.shared.domain.event.EventPublisher;
import dev.waltercrdz.api.ecommerce.orders.domain.event.OrderCreatedDomainEvent;

import java.util.Objects;

import org.springframework.stereotype.Service;

@Service
public class OrderCreator {

    private final OrderCommandRepository writer;
    private final EventPublisher eventPublisher;

    public OrderCreator(OrderCommandRepository writer, EventPublisher eventPublisher) {
        this.writer = writer;
        this.eventPublisher = eventPublisher;
    }

    public void create(Order order) {
        checkArgument(Objects.nonNull(order), "order cannot be null");
        this.writer.save(order);
        final var event = OrderCreatedDomainEvent.from(order);
        this.eventPublisher.publish(event);
    }
}
