package com.portfolio.dsdelivery.domain.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_products")
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private Double price;
	private String description;
	private String imageUri;
	
	@Deprecated
	public Product() {
	}
	
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
		
		public Product build() {
			return new Product(this);
		}
	}
	
	private Product(Builder builder) {
		this.id = null;
		this.name = builder.name;
		this.price = builder.price;
		this.description = builder.description;
		this.imageUri = builder.imageUri;
	}

	public Long getId() {
		return id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + "," + System.lineSeparator() +
				"name=" + name + "," + System.lineSeparator() +
				"price=" + price + "," + System.lineSeparator() +
				"description=" + description + "," + System.lineSeparator() +
				"imageUri=" + imageUri + "]";
	}
	
	

}
