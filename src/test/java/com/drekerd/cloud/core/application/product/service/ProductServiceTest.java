package com.drekerd.cloud.core.application.product.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.drekerd.cloud.core.application.product.repository.ProductRepository;
import com.drekerd.cloud.core.domain.product.Product;
import com.drekerd.cloud.entrypoint.response.ProductDTO;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

	@InjectMocks
	ProductServiceImpl productServiceImpl;

	@Mock
	ProductRepository productRepository;

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

	@Test
	public void get_product_by_name_returns_Nr_of_elements() {
		createObjects();
		when(productRepository.findAllProducts()).thenReturn(products);
		List<ProductDTO> products = productServiceImpl.getProductByName("Ketchup");
		assertEquals(3, products.size());
		assertEquals("ketchup", products.get(0).getName());
		assertEquals("Ketchup", products.get(1).getName());
		assertEquals("Ketchup", products.get(2).getName());
	}

	@Test
	public void get_product_by_name_returns_Sort_by_Price() {
		createObjects();
		when(productRepository.findAllProducts()).thenReturn(products);
		List<ProductDTO> products = productServiceImpl.getProductByName("Ketchup");
		assertEquals(3, products.size());
		assertEquals("1.00", products.get(0).getPrice().toString());
		assertEquals("1.50", products.get(1).getPrice().toString());
		assertEquals("1.60", products.get(2).getPrice().toString());
	}

	@Test
	public void get_product_by_name_returns_empty_list_when_string_empty() {
		createObjects();
		when(productRepository.findAllProducts()).thenReturn(products);
		List<ProductDTO> products = productServiceImpl.getProductByName("");

		assertEquals(0, products.size());
	}

	@Test
	public void get_product_by_name_returns_empty_list_when_product_not_exist() {
		createObjects();
		when(productRepository.findAllProducts()).thenReturn(products);
		List<ProductDTO> products = productServiceImpl.getProductByName("texugo");

		assertEquals(0, products.size());
	}

	@Test
	public void get_all_products() {
		createObjects();
		when(productRepository.findAllProducts()).thenReturn(products);
		List<ProductDTO> products = productServiceImpl.getAllProducts();
		assertEquals(5, products.size());
	}

	@Test
	public void get_all_products_sort_by_price() {
		createObjects();
		when(productRepository.findAllProducts()).thenReturn(products);
		List<ProductDTO> products = productServiceImpl.getAllProducts();

		assertEquals(5, products.size());
		assertEquals("1.00", products.get(0).getPrice().toString());
		assertEquals("1.00", products.get(1).getPrice().toString());
		assertEquals("1.30", products.get(2).getPrice().toString());
		assertEquals("1.50", products.get(3).getPrice().toString());
		assertEquals("1.60", products.get(4).getPrice().toString());
	}

}
