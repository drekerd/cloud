package com.drekerd.cloud.core.application.product.service;

import java.util.List;
import com.drekerd.cloud.entrypoint.response.ProductDTO;

public interface ProductService {

	List<ProductDTO> getProductByName(final String name);

	List<ProductDTO> getAllProducts();

}
