package dev.waltercrdz.api.ecommerce.shared.domain.exception;

import java.util.Map;
import java.util.UUID;

public class ProductNotFoundException extends DomainException {

    public ProductNotFoundException(String message, UUID productId) {
        super(message, ErrorCode.PRODUCT_NOT_FOUND, Map.of("product_id", productId));
    }
}
