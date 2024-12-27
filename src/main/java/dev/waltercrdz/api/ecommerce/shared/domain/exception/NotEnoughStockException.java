package dev.waltercrdz.api.ecommerce.shared.domain.exception;

import java.util.Map;
import java.util.UUID;

public class NotEnoughStockException extends DomainException {

    public NotEnoughStockException(String message, UUID productId) {
        super(message, ErrorCode.NOT_ENOUGH_STOCK, Map.of("product_id", productId));
    }
}
