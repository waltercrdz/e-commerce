package dev.waltercrdz.api.ecommerce.products.infrastructure.in.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.waltercrdz.api.ecommerce.products.application.ProductFinder;
import dev.waltercrdz.api.ecommerce.products.infrastructure.in.dto.ProductResponse;
import dev.waltercrdz.api.ecommerce.products.infrastructure.in.mapper.ProductMapper;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductFinder finder;

    public ProductController(ProductFinder finder) {
        this.finder = finder;
    }

    @GetMapping("/{id}")
    public ProductResponse getProduct(UUID id) {
        final var product = this.finder.find(id);
        return ProductMapper.toResponse(product);
    }

    @GetMapping
    public List<ProductResponse> getProducts() {
        final var products = this.finder.findAll();
        return products.stream()
                       .map(ProductMapper::toResponse)
                       .collect(Collectors.toList());
    }

}
