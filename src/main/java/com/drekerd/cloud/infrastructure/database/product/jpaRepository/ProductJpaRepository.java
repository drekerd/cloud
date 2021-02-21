package com.drekerd.cloud.infrastructure.database.product.jpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drekerd.cloud.core.domain.product.Product;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {
}
