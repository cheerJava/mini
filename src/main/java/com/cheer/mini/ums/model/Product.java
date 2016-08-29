package com.cheer.mini.ums.model;

import java.math.BigDecimal;
import java.util.Date;

import com.cheer.mini.base.model.BaseEntity;

public class Product extends BaseEntity {
	private String id;

	private String name;

	private String description;

	private BigDecimal price;

	private String imageFullPath;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getImageFullPath() {
		return imageFullPath;
	}

	public void setImageFullPath(String imageFullPath) {
		this.imageFullPath = imageFullPath == null ? null : imageFullPath
				.trim();
	}
}