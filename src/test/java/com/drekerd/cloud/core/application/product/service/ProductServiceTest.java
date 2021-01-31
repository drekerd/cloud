package com.drekerd.cloud.core.application.product.service;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.drekerd.cloud.core.domain.product.Product;
import com.drekerd.cloud.entrypoint.response.ProductDTO;
import com.drekerd.cloud.infrastructure.database.product.repository.ProductRepositoryImpl;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

	@InjectMocks
	ProductServiceImpl productServiceImpl;

	@Mock
	ProductRepositoryImpl productRepository;

	@Before
	public void prepare() {
		MockitoAnnotations.openMocks(this);
	}

	final private List<Product> products = new ArrayList<>();
	final private List<Product> emptyList = new ArrayList<>();

	public void createObjects() {
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
	}

	@Before
	public void create() {
		createObjects();
	}

	// Not possible to test this motherfucker!!!! always returns 0, EMPTY, BOLA! :facepalm:
	@Test
	public void get_product_by_name() {
		when(productRepository.findAllProducts()).thenReturn(products);
		List<ProductDTO> products = productServiceImpl.getProductByName("Ketchup");
		System.out.println("SIZE: " + products.size());
	}
}
