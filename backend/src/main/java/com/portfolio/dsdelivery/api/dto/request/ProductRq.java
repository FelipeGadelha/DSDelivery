package com.portfolio.dsdelivery.api.dto.request;

import java.io.Serializable;

public class ProductRq implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Double price;
	private String description;
	private String imageUri;

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

	@Override
	public String toString() {
		return "ProductRq [name=" + name + ", price=" + price + ", description=" + description + ", imageUri="
				+ imageUri + "]";
	}
	
	
}
