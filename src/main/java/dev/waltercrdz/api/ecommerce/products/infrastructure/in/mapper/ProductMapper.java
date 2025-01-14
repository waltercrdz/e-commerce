package dev.waltercrdz.api.ecommerce.products.infrastructure.in.mapper;

import dev.waltercrdz.api.ecommerce.products.domain.model.Product;
import dev.waltercrdz.api.ecommerce.products.infrastructure.in.dto.ProductResponse;

public class ProductMapper {

    public static ProductResponse toResponse(Product product) {
        return new ProductResponse(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            product.getStock());
    }
}
