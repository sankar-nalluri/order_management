package com.orderitem.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_code", nullable=false)
	private Long product_code;
	
	@Column(name = "product_name", nullable=false)
	private String product_name;
	
	@Column(name = "quantity", nullable=false)
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
