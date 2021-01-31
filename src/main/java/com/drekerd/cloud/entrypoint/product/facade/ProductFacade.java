package com.drekerd.cloud.entrypoint.product.facade;

import java.util.List;

import com.drekerd.cloud.entrypoint.response.ProductDTO;

public interface ProductFacade {

	List<ProductDTO> getProduct(final String name);

	List<ProductDTO> getAllProducts();

}
