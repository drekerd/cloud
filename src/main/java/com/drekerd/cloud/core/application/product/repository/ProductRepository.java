package com.drekerd.cloud.core.application.product.repository;

import java.util.List;

import com.drekerd.cloud.core.domain.product.Product;

public interface ProductRepository {

	List<Product> findAllProducts();

}
