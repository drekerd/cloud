package com.drekerd.cloud.entrypoint.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drekerd.cloud.entrypoint.BaseController;
import com.drekerd.cloud.entrypoint.product.facade.ProductFacade;
import com.drekerd.cloud.entrypoint.response.ProductDTO;

@RestController
@RequestMapping("api/v1/products")
public class ProductController extends BaseController {

	@Autowired
	ProductFacade productFacade;

	@GetMapping("product/{name}")
	public ResponseEntity<List<ProductDTO>> getProductsByName(@PathVariable final String name){
		List<ProductDTO> productDTOS = productFacade.getProduct(name);
		return createOkResponse(productDTOS);
	}

	@GetMapping("/")
	public ResponseEntity<List<ProductDTO>> getAllAproducts(){
		return createOkResponse(productFacade.getAllProducts());
	}
}
