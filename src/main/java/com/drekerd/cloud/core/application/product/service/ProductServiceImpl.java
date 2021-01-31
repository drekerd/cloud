package com.drekerd.cloud.core.application.product.service;

import com.drekerd.cloud.core.domain.product.Product;
import com.drekerd.cloud.entrypoint.response.ProductDTO;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

	private final List<Product> products = new ArrayList<>();

	//Temporary ofc
	@PostConstruct
	private void constructor() {

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

		products.add(product1);
		products.add(product2);
		products.add(product3);
		products.add(product4);

	}

	@Override
	public List<ProductDTO> getProductByName(String name) {
		List<Product> products = getProductsWithName(name);
		return productDTOConverter(products);
	}

	public List<ProductDTO> getAllProducts() {
		return productDTOConverter(products);
	}

	private List<Product> getProductsWithName(final String name) {
		List<Product> finalProducts = new ArrayList<>();
		for (Product product : products) {
			if (product.getName().equalsIgnoreCase(name)) {
				finalProducts.add(product);
			}
		}
		return finalProducts;
	}

	private List<ProductDTO> productDTOConverter(final List<Product> products) {
		List<ProductDTO> finalProductsDTO = new ArrayList<>();
		for (Product product : products) {
			finalProductsDTO.add(ProductDTO.builder()
					.id(product.getId())
					.name(product.getName())
					.currency(product.getCurrency())
					.price(product.getPrice())
					.origin(product.getOrigin())
					.build());
		}
		System.out.println(finalProductsDTO.get(1).getPrice());
		return finalProductsDTO;
	}
}
