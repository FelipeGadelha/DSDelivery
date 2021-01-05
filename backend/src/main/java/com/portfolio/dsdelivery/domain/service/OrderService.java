package com.portfolio.dsdelivery.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portfolio.dsdelivery.api.dto.response.OrderRs;
import com.portfolio.dsdelivery.domain.entity.Order;
import com.portfolio.dsdelivery.domain.repository.OrderRepository;

@Service
public class OrderService {
	
	private final OrderRepository orderRepository;
	
	private final ModelMapper mapper;
	
	@Autowired
	public OrderService(OrderRepository orderRepository,  ModelMapper mapper) {
		this.orderRepository = orderRepository;
		this.mapper = mapper;
	}
	
	@Transactional(readOnly = true)
	public List<OrderRs> findAll(){
		List<Order> orders = orderRepository.findOrdersWithProducts();
		return orders.stream().map(entity -> mapper.map(entity, OrderRs.class)).collect(Collectors.toList());
		
	}
	
	
	
	
	
}
