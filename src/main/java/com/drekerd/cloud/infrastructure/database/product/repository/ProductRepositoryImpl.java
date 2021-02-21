package com.drekerd.cloud.infrastructure.database.product.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.drekerd.cloud.core.application.product.repository.ProductRepository;
import com.drekerd.cloud.core.domain.product.Product;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Repository
public class ProductRepositoryImpl implements ProductRepository {

	private final List<Product> products = new ArrayList<>();

	//Temporary ofc
	private List<Product> constructor() {

		Product product1 = new Product.ProductBuilder()
				.withId(1)
				.withName("Ketchup")
				.withPrice(new BigDecimal("1.50"))
				.withCurrency("EUR")
				.withOrigin("Pingo Doce")
				.build();

		Product product2 = new Product.ProductBuilder()
				.withId(2)
				.withName("Ketchup")
				.withPrice(new BigDecimal("1.60"))
				.withCurrency("EUR")
				.withOrigin("Continente")
				.build();

		Product product3 = new Product.ProductBuilder()
				.withId(3)
				.withName("Maionese")
				.withPrice(new BigDecimal("1.30"))
				.withCurrency("EUR")
				.withOrigin("Continente")
				.build();

		Product product4 = new Product.ProductBuilder()
				.withId(4)
				.withName("Barbacue")
				.withPrice(new BigDecimal("1.00"))
				.withCurrency("EUR")
				.withOrigin("Lidl")
				.build();

		Product product5 = new Product.ProductBuilder()
				.withId(5)
				.withName("ketchup")
				.withPrice(new BigDecimal("1.00"))
				.withCurrency("EUR")
				.withOrigin("Lidl")
				.build();

		products.add(product1);
		products.add(product2);
		products.add(product3);
		products.add(product4);
		products.add(product5);

		return products;
	}

	@Override
	public List<Product> findAllProducts() {
		return constructor();
	}
}
