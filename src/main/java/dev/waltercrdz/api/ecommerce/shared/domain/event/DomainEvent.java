package dev.waltercrdz.api.ecommerce.shared.domain.event;

import java.time.Instant;
import java.util.UUID;

public abstract class DomainEvent {
    public final String eventId;
    public final EventType eventType;
    public final Instant occurredAt;

    protected DomainEvent(EventType eventType) {
        this.eventId = UUID.randomUUID().toString();
        this.occurredAt = Instant.now();
        this.eventType = eventType;
    }
}
