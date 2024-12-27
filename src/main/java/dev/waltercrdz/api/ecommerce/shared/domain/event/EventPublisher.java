package dev.waltercrdz.api.ecommerce.shared.domain.event;

public interface EventPublisher {

    void publish(DomainEvent event);
}
