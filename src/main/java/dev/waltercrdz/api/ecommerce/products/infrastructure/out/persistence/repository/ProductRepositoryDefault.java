package dev.waltercrdz.api.ecommerce.products.infrastructure.out.persistence.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import dev.waltercrdz.api.ecommerce.products.domain.model.Product;
import dev.waltercrdz.api.ecommerce.products.domain.repository.ProductCommandRepository;
import dev.waltercrdz.api.ecommerce.products.domain.repository.ProductQueryRepository;
import dev.waltercrdz.api.ecommerce.products.infrastructure.out.persistence.mapper.ProductMapper;

@Repository
public class ProductRepositoryDefault implements ProductCommandRepository, ProductQueryRepository {

    private final ProductPostgresRepository productPostgresRepository;

    public ProductRepositoryDefault(ProductPostgresRepository productPostgresRepository) {
        this.productPostgresRepository = productPostgresRepository;
    }

    @Override
    public Optional<Product> findById(UUID product_id) {
        return this.productPostgresRepository.findById(product_id)
            .map(ProductMapper::toDomain);
    }

    public List<Product> findAll() {
        return this.productPostgresRepository.findAll()
            .stream()
            .map(ProductMapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public void save(Product product) {
        this.productPostgresRepository.save(ProductMapper.toEntity(product));
    }

}
