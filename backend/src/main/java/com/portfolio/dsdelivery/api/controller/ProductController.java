package com.portfolio.dsdelivery.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.dsdelivery.api.dto.response.ProductRs;
import com.portfolio.dsdelivery.domain.service.ProductService;

@RestController
@RequestMapping(value = "/v1/products")
public class ProductController {

	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		List<ProductRs> products = productService.findAll();
		return ResponseEntity.ok().body(products);
	}
	
}
