package com.portfolio.dsdelivery.domain.service;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portfolio.dsdelivery.api.dto.request.OrderRq;
import com.portfolio.dsdelivery.api.dto.response.OrderRs;
import com.portfolio.dsdelivery.domain.entity.Order;
import com.portfolio.dsdelivery.domain.entity.OrderStatus;
import com.portfolio.dsdelivery.domain.entity.Product;
import com.portfolio.dsdelivery.domain.repository.OrderRepository;
import com.portfolio.dsdelivery.domain.repository.ProductRepository;

@Service
public class OrderService {
	
	private final OrderRepository orderRepository;
	private final ProductRepository productRepository;
	
	private final ModelMapper mapper;
	
	@Autowired
	public OrderService(OrderRepository orderRepository, ProductRepository productRepository, ModelMapper mapper) {
		this.orderRepository = orderRepository;
		this.productRepository = productRepository;
		this.mapper = mapper;
	}
	
	@Transactional(readOnly = true)
	public List<OrderRs> findAll(){
		List<Order> orders = orderRepository.findOrdersWithProducts();
		return orders.stream().map(entity -> mapper.map(entity, OrderRs.class)).collect(Collectors.toList());
		
	}
	
	@Transactional
	public OrderRs save(OrderRq orderRq) {
		Order order = toEntity(orderRq);
		order.setMoment(Instant.now());
		order.setStatus(OrderStatus.PENDING);
		Set<Product> products = new HashSet<>();
		orderRq.getProducts().stream().forEach(p -> products.add(productRepository.getOne(p.getId())));
		order.setProducts(products);
		Order save = orderRepository.save(order);
		return toResponse(save);
		
	}
	
	@Transactional
	public OrderRs delivered(Long id) {
		Order order = orderRepository.getOne(id);
		order.setStatus(OrderStatus.DELIVERED);
		return toResponse(orderRepository.save(order));
	}
	
	private Order toEntity(OrderRq orderRq) {
		return mapper.map(orderRq, Order.class);
	}
	
	private OrderRs toResponse(Order order) {
		return mapper.map(order, OrderRs.class);
	}	
}
