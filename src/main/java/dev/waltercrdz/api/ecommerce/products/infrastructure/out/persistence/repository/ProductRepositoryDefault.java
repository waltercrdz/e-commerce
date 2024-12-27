package dev.waltercrdz.api.ecommerce.products.infrastructure.out.persistence.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import dev.waltercrdz.api.ecommerce.products.domain.model.Product;
import dev.waltercrdz.api.ecommerce.products.domain.repository.ProductCommandRepository;
import dev.waltercrdz.api.ecommerce.products.infrastructure.out.persistence.mapper.ProductMapper;

@Repository
public class ProductRepositoryDefault implements ProductCommandRepository {

    private final ProductPostgresRepository productPostgresRepository;

    public ProductRepositoryDefault(ProductPostgresRepository productPostgresRepository) {
        this.productPostgresRepository = productPostgresRepository;
    }

    @Override
    public Optional<Product> findById(UUID product_id) {
        return this.productPostgresRepository.findById(product_id)
            .map(ProductMapper::toDomain);
    }

    @Override
    public void save(Product product) {
        this.productPostgresRepository.save(ProductMapper.toEntity(product));
    }

}
