package com.portfolio.dsdelivery.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.portfolio.dsdelivery.api.dto.request.OrderRq;
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
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody OrderRq orderRq){
		OrderRs save = orderService.save(orderRq);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(save.getId()).toUri();
		return ResponseEntity.created(uri).body(save);
	}
	
	
}
