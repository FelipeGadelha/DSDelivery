package com.portfolio.dsdelivery.api.dto.request;

import java.io.Serializable;

public class ProductRq implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private final String name;
	private final Double price;
	private final String description;
	private final String imageUri;
	
	public static class Builder {

		private String name;
		private Double price;
		private String description;
		private String imageUri;

		public Builder() {
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder price(Double price) {
			this.price = price;
			return this;
		}
		
		public Builder description(String description) {
			this.description = description;
			return this;
		}
		
		public Builder imageUri(String imageUri) {
			this.imageUri = imageUri;
			return this;
		}
		
		public ProductRq build() {
			return new ProductRq(this);
		}
	}

	private ProductRq(Builder builder) {
		this.name = builder.name;
		this.price = builder.price;
		this.description = builder.description;
		this.imageUri = builder.imageUri;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public String getImageUri() {
		return imageUri;
	}
}
