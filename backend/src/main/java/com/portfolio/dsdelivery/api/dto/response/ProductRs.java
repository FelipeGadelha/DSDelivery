package com.portfolio.dsdelivery.api.dto.response;

import java.io.Serializable;

public class ProductRs implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Double price;
	private String description;
	private String imageUri;
	
	@Deprecated
	public ProductRs() {
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUri() {
		return imageUri;
	}
	
	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}
}
