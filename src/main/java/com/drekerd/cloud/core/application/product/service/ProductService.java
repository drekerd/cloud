package com.drekerd.cloud.core.application.product.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.drekerd.cloud.core.domain.product.Product;
import com.drekerd.cloud.entrypoint.response.ProductDTO;

public interface ProductService {

	List<ProductDTO> getProductByName(final String name);

	List<ProductDTO> getAllProducts();

}
