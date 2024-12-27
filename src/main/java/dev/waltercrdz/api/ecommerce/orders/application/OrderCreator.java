package dev.waltercrdz.api.ecommerce.orders.application;

import static com.google.common.base.Preconditions.checkArgument;

import dev.waltercrdz.api.ecommerce.orders.domain.model.Order;
import dev.waltercrdz.api.ecommerce.orders.domain.repository.OrderCommandRepository;
import dev.waltercrdz.api.ecommerce.products.application.ProductStockUpdater;
import dev.waltercrdz.api.ecommerce.shared.domain.event.EventPublisher;
import dev.waltercrdz.api.ecommerce.orders.domain.event.OrderCreatedDomainEvent;

import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderCreator {

    private final ProductStockUpdater productStockUpdater;
    private final OrderCommandRepository writer;
    private final EventPublisher eventPublisher;

    public OrderCreator(ProductStockUpdater productStockUpdater, OrderCommandRepository writer, EventPublisher eventPublisher) {
        this.productStockUpdater = productStockUpdater;
        this.writer = writer;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public void create(Order order) {
        checkArgument(Objects.nonNull(order), "Order cannot be null");

        writer.save(order);
        order.getProducts().forEach(productOrder -> {
            productStockUpdater.updateStock(productOrder.getProductId(), productOrder.getQuantity());
        });
        final var event = OrderCreatedDomainEvent.from(order);
        eventPublisher.publish(event);
    }
}
