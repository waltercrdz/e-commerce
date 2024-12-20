package dev.waltercrdz.api.ecommerce.shared.infrastructure.event;

import dev.waltercrdz.api.ecommerce.shared.domain.event.EventPublisher;
import dev.waltercrdz.api.ecommerce.shared.domain.event.DomainEvent;
import io.awspring.cloud.sns.core.SnsNotification;
import io.awspring.cloud.sns.core.SnsOperations;

import java.util.List;

public class SnsPublisher implements EventPublisher {
    private final SnsOperations snsOperations;
    private final String topicArn;

    public SnsPublisher(SnsOperations snsOperations, String topicArn) {
        this.snsOperations = snsOperations;
        this.topicArn = topicArn;
    }

    @Override
    public void publish(DomainEvent event) {
        final var notification = SnsNotification.builder(event).build();
        snsOperations.sendNotification(topicArn, notification);
    }
}
