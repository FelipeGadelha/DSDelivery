package com.portfolio.dsdelivery.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portfolio.dsdelivery.api.dto.response.ProductRs;
import com.portfolio.dsdelivery.domain.entity.Product;
import com.portfolio.dsdelivery.domain.repository.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	
	private final ModelMapper mapper;
	
	@Autowired
	public ProductService(ProductRepository productRepository,  ModelMapper mapper) {
		this.productRepository = productRepository;
		this.mapper = mapper;
	}
	
	@Transactional(readOnly = true)
	public List<ProductRs> findAll(){
		List<Product> products = productRepository.findAll();
		return products.stream().map(entity -> mapper.map(entity, ProductRs.class)).collect(Collectors.toList());
		
	}
	
	
	
	
	
}
