package com.portfolio.dsdelivery.api.dto.request;

import java.io.Serializable;

public class IdProductRq implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "IdProductRq [id=" + id + "]";
	}
	
	
}
