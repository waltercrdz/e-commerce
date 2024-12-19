package dev.waltercrdz.api.ecommerce.shared.domain.event;

public enum EventType {
    ORDER_CREATED("order_created"),
    ORDER_UPDATED("order_updated");

    private final String value;

    EventType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
