package com.cheer.mini.tinglin.dto;

import java.util.List;

import com.cheer.mini.base.Page;
import com.cheer.mini.ums.model.Product;



public class ProductView {

	private Product condition;
	
	private List<Product> list;
	
	private Product proInfo;
    
	private Page page;
	
	public ProductView(Product condition, List<Product> list, Product proInfo) {
		super();
		this.condition = condition;
		this.list = list;
		this.proInfo = proInfo;
	}
	
	public ProductView() {
	}
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Product getCondition() {
		return condition;
	}


	public void setCondition(Product condition) {
		this.condition = condition;
	}


	public List<Product> getList() {
		return list;
	}


	public void setList(List<Product> list) {
		this.list = list;
	}


	public Product getProInfo() {
		return proInfo;
	}


	public void setProInfo(Product proInfo) {
		this.proInfo = proInfo;
	}

	@Override
	public String toString() {
		return "ProductView [condition=" + condition + ", list=" + list + ", proInfo=" + proInfo + ", page=" + page
				+ "]";
	}
	
	
}
