package com.drekerd.cloud.core.application.product.service;

import com.drekerd.cloud.core.application.product.repository.ProductRepository;
import com.drekerd.cloud.core.domain.product.Product;
import com.drekerd.cloud.entrypoint.response.ProductDTO;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
//@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class ProductServiceImpl implements ProductService {

	/*Need to understand the @RequiredArgsConstructor :facepalm: */

	private final ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<ProductDTO> getProductByName(String name) {
		List<Product> products = getProductsWithName(name);
		List<Product> productsSorted = sortProducts(products);
		return productDTOConverter(productsSorted);
	}

	public List<ProductDTO> getAllProducts() {
		List<Product> products = productRepository.findAllProducts();
		List<Product> productsSorted = sortProducts(products);
		return productDTOConverter(productsSorted);
	}

	private List<Product> getProductsWithName(final String name) {
		List<Product> products = productRepository.findAllProducts();
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
		return finalProductsDTO;
	}

	private List<Product> sortProducts(List<Product> products) {
		products.sort(new Comparator<Product>() {
			@Override
			public int compare(Product product1, Product product2) {
				int comparison = 0;
				comparison = product1.getPrice().compareTo(product2.getPrice());
				return comparison;
			}
		});
		return products;
	}

}
