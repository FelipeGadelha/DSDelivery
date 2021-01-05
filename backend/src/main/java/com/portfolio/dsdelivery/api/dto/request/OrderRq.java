package com.portfolio.dsdelivery.api.dto.request;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class OrderRq implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String address;
	private Double latitude;
	private Double longitude;
	private Set<IdProductRq> products = new HashSet<>();
	
	public OrderRq() {}
	
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

	public Set<IdProductRq> getProducts() {
		return products;
	}
	
	public void setProducts(Set<IdProductRq> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "OrderRq [address=" + address + ", latitude=" + latitude + ", longitude=" + longitude + ", products="
				+ products + "]";
	}
	
	
}
