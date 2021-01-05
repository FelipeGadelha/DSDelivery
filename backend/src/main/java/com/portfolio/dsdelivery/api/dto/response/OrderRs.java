package com.portfolio.dsdelivery.api.dto.response;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.portfolio.dsdelivery.domain.entity.OrderStatus;

public class OrderRs implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String address;
	private Double latitude;
	private Double longitude;
	private Instant moment;
	private OrderStatus status;
	
	private List<ProductRs> products = new ArrayList<>();
	
	@Deprecated
	public OrderRs() {
	}

	public OrderRs(Long id, String address, Double latitude, Double longitude, Instant moment, OrderStatus status) {
		this.id = id;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.moment = moment;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getMoment() {
		return moment.toString();
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<ProductRs> getProducts() {
		return products;
	}

	public void setProducts(List<ProductRs> products) {
		this.products = products;
	}
	
	
	
	
}
