package com.drekerd.cloud.entrypoint.product.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drekerd.cloud.core.application.product.service.ProductService;
import com.drekerd.cloud.entrypoint.response.ProductDTO;

@Service
public class ProductFacadeImpl implements ProductFacade{

	@Autowired
	ProductService productService;

	@Override
	public List<ProductDTO> getProduct(String name) {
		return productService.getProductByName(name);
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		return productService.getAllProducts();
	}
}
