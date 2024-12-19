package dev.waltercrdz.api.ecommerce.shared.domain.event;

import java.util.List;

public interface EventPublisher {

    void publish(DomainEvent event);
    void publish(List<DomainEvent> events);
}
