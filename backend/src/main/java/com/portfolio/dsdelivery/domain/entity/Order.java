package com.portfolio.dsdelivery.domain.entity;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_orders")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String address;
	private Double latitude;
	private Double longitude;
	private Instant moment;
	private OrderStatus status;
	
	@ManyToMany
	@JoinTable(name = "tb_order_product",
			joinColumns = @JoinColumn(name = "order_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id"))
	private Set<Product> products = new HashSet<>();
	
	@Deprecated
	public Order() {
	}
	
	private Order(Builder builder) {
		this.id = null;
		this.address = builder.address;
		this.latitude = builder.latitude;
		this.longitude = builder.longitude;
		this.moment = builder.moment;
		this.status = builder.status;
	}
	
	public static class Builder {

		private String address;
		private Double latitude;
		private Double longitude;
		private Instant moment;
		private OrderStatus status;
		private Set<Product> products = new HashSet<>();

		public Builder() {
		}

		public Builder address(String address) {
			this.address = address;
			return this;
		}

		public Builder latitude(Double latitude) {
			this.latitude = latitude;
			return this;
		}

		public Builder longitude(Double longitude) {
			this.longitude = longitude;
			return this;
		}
		
		public Builder moment(Instant moment) {
			this.moment = moment;
			return this;
		}
		
		public Builder status(OrderStatus status) {
			this.status = status;
			return this;
		}
		
		public Order build() {
			return new Order(this);
		}
	}

	public Long getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public Instant getMoment() {
		return moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public Set<Product> getProducts() {
		return products;
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
