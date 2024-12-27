package dev.waltercrdz.api.ecommerce.orders.infrastructure.utils;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import dev.waltercrdz.api.ecommerce.orders.infrastructure.in.dto.OrderCreationRequest;
import dev.waltercrdz.api.ecommerce.orders.infrastructure.in.dto.ProductOrderRequest;

public class OrderCreationRequestMother {

    public static final String PRODUCT_ID_STOCK_10 = "f7b3b3b4-3b1b-4b3b-8b3b-3b1b3b1b3b1b";
    public static final String PRODUCT_ID_STOCK_0 = "f7b3b3b4-3b1b-4b3b-8b3b-3b1b3b1b3b1c";
    public static final String PRODUCT_ID_STOCK_5 = "f7b3b3b4-3b1b-4b3b-8b3b-3b1b3b1b3b1d";
    public static final String PRODUCT_ID_NOT_FOUND = "f7b3b3b4-3b1b-4b3b-8b3b-3b1b3b1b3b1z";

    public static final String INVALID_CUSTOMER_ID = "invalid-customer-id";

    public static OrderCreationRequest createValid() {
        return new OrderCreationRequest(
            UUID.randomUUID().toString(),
            List.of(
                new ProductOrderRequest(PRODUCT_ID_STOCK_10, 10, BigDecimal.TEN)
            )
        );
    }
    
    public static OrderCreationRequest createWithInvalidCustomerId() {
        return new OrderCreationRequest(
            INVALID_CUSTOMER_ID,
            List.of(
                new ProductOrderRequest(PRODUCT_ID_STOCK_10, 10, BigDecimal.TEN)
            )
        );
    }
    
    public static OrderCreationRequest createWithProductOrderQuantityZero() {
        return new OrderCreationRequest(
            UUID.randomUUID().toString(),
            List.of(
                new ProductOrderRequest(PRODUCT_ID_STOCK_10, 0, BigDecimal.TEN)
            )
        );
    }
    
    public static OrderCreationRequest createWithEmptyProductList() {
        return new OrderCreationRequest(UUID.randomUUID().toString(), List.of());
    }

    public static OrderCreationRequest createWithProductOutOfStock() {
        return new OrderCreationRequest(
            UUID.randomUUID().toString(),
            List.of(
                new ProductOrderRequest(PRODUCT_ID_STOCK_0, 10, BigDecimal.TEN)
            )
        );
    }
    
    public static OrderCreationRequest createWithProductNotExist() {
        return new OrderCreationRequest(
            UUID.randomUUID().toString(),
            List.of(
                new ProductOrderRequest(PRODUCT_ID_NOT_FOUND, 10, BigDecimal.TEN)
            )
        );
    }
}
