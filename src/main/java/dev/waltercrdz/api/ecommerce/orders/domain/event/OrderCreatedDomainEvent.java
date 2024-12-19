package dev.waltercrdz.api.ecommerce.orders.domain.event;

import dev.waltercrdz.api.ecommerce.orders.domain.model.Order;
import dev.waltercrdz.api.ecommerce.shared.domain.event.DomainEvent;
import dev.waltercrdz.api.ecommerce.shared.domain.event.EventType;

public class OrderCreatedDomainEvent extends DomainEvent {

    public final String orderId;

    private OrderCreatedDomainEvent(String orderId) {
        super(EventType.ORDER_CREATED);
        this.orderId = orderId;
    }

    public static OrderCreatedDomainEvent from(Order order) {
        return new OrderCreatedDomainEvent(order.getId().toString());
    }
}
