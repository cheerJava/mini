package com.cheer.mini.ums.model;

import java.math.BigDecimal;

public class OrderItem {
	private String id;
	
	private String orderId;
	
	private int number;
	
	private BigDecimal price;
	
	private String productName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", orderId=" + orderId + ", number="
				+ number + ", price=" + price + ", productName=" + productName
				+ "]";
	}
	
}
