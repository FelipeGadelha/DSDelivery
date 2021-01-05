package com.portfolio.dsdelivery.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.dsdelivery.api.dto.response.OrderRs;
import com.portfolio.dsdelivery.domain.service.OrderService;

@RestController
@RequestMapping(value = "/v1/orders")
public class OrderController {

	private final OrderService orderService;
	
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		List<OrderRs> orders = orderService.findAll();
		return ResponseEntity.ok().body(orders);
	}
	
}
