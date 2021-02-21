package com.drekerd.cloud.entrypoint.product.cotroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.drekerd.cloud.entrypoint.product.controller.ProductController;
import com.drekerd.cloud.entrypoint.product.facade.ProductFacade;
import com.drekerd.cloud.entrypoint.response.ProductDTO;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

	@InjectMocks
	ProductController controller;

	@Mock
	ProductFacade facade;

	final private List<ProductDTO> products = new ArrayList<>();

	public void createObjects() {

		products.add(ProductDTO.builder()
				.id(1)
				.name("Ketchup")
				.currency("EUR")
				.price(new BigDecimal("1.50"))
				.origin("Pingo Doce")
				.build());

		products.add(ProductDTO.builder()
				.id(2)
				.name("Ketchup")
				.price(new BigDecimal("1.60"))
				.currency("EUR")
				.origin("Continente")
				.build());

		products.add(ProductDTO.builder()
				.id(3)
				.name("Maionese")
				.price(new BigDecimal("1.30"))
				.currency("EUR")
				.origin("Continente")
				.build());

		products.add(ProductDTO.builder()
				.id(4)
				.name("Barbacue")
				.currency("EUR")
				.price(new BigDecimal("1"))
				.origin("Lidl")
				.build());
	}

	@BeforeEach
	public void create() {
		createObjects();
	}

	@Test
	public void get_product_by_name_response200() {

		when(facade.getProduct(anyString())).thenReturn(products);

		final ResponseEntity<List<ProductDTO>> response = controller.getProductsByName("Ketchup");

		assertSame(products.get(0).getName(), Objects.requireNonNull(response.getBody()).get(0).getName());
		assertSame(products.get(0).getPrice(), Objects.requireNonNull(response.getBody()).get(0).getPrice());
		assertSame(products.get(0).getCurrency(), Objects.requireNonNull(response.getBody()).get(0).getCurrency());
		assertSame(products.get(0).getOrigin(), Objects.requireNonNull(response.getBody()).get(0).getOrigin());
		assertSame(4, Objects.requireNonNull(response.getBody()).size());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	public void get_product_withoutName_response200() {

		when(facade.getProduct(anyString())).thenReturn(Collections.emptyList());

		final ResponseEntity<List<ProductDTO>> response = controller.getProductsByName("");
		assertSame(0, Objects.requireNonNull(response.getBody()).size());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	public void get_all_products_response200() {
		when(facade.getAllProducts()).thenReturn(products);

		final ResponseEntity<List<ProductDTO>> response = controller.getAllProducts();

		assertSame(products.get(0).getName(), Objects.requireNonNull(response.getBody()).get(0).getName());
		assertSame(products.get(0).getPrice(), Objects.requireNonNull(response.getBody()).get(0).getPrice());
		assertSame(products.get(0).getCurrency(), Objects.requireNonNull(response.getBody()).get(0).getCurrency());
		assertSame(products.get(0).getOrigin(), Objects.requireNonNull(response.getBody()).get(0).getOrigin());
		assertSame(4, Objects.requireNonNull(response.getBody()).size());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
}
