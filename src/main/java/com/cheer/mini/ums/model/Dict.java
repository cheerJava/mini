package com.cheer.mini.ums.model;

import java.io.Serializable;

import com.cheer.mini.base.model.BaseEntity;

public class Dict extends BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 945618667667219704L;

	private String id;

	private int value;

	private String label;

	private String type;

	private String description;

	private Long sort;
	
	
	
	@Override
	public String toString() {
		return "Dict [id=" + id + ", value=" + value + ", label=" + label + ", type=" + type + ", description="
				+ description + ", sort=" + sort + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label == null ? null : label.trim();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public Long getSort() {
		return sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}

}