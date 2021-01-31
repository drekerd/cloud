package com.drekerd.cloud.core.application.product.repository;

import java.util.List;

import com.drekerd.cloud.core.domain.product.Product;

public interface ProductRepository {

	/**
	 *
	 * To Bruno,why this interface is in Core, instead of Infrastructure?
	 * */

	List<Product> findAllProducts();

}
