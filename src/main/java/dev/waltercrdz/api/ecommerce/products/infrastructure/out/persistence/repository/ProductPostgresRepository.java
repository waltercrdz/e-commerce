package dev.waltercrdz.api.ecommerce.products.infrastructure.out.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.waltercrdz.api.ecommerce.products.infrastructure.out.persistence.entity.ProductEntity;

@Repository
public interface ProductPostgresRepository extends JpaRepository<ProductEntity, UUID> {
    
}
