package com.ordermgmt.service.model;

public class Item {
	
	private Long product_code;
	
	private String product_name;
	
	private Integer quantity;

	public Long getProduct_code() {
		return product_code;
	}

	public void setProduct_code(Long product_code) {
		this.product_code = product_code;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Item [product_code=" + product_code + ", product_name=" + product_name + ", quantity=" + quantity + "]";
	}

}
