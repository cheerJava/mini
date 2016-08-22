package com.cheer.mini.ums.model;

import java.math.BigDecimal;

import com.cheer.mini.base.model.BaseEntity;

public class Product extends BaseEntity {
	private String id;
	
    private String name;

    private String desc;
    
    private String imageFullPath;
    
    private BigDecimal price;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getImageFullPath() {
		return imageFullPath;
	}

	public void setImageFullPath(String imageFullPath) {
		this.imageFullPath = imageFullPath;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", desc=" + desc
				+ ", imageFullPath=" + imageFullPath + ", price=" + price + "]";
	}
    
    
}
