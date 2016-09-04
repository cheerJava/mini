package com.cheer.mini.ums.dto;

import java.util.List;

import com.cheer.mini.base.Page;
import com.cheer.mini.ums.model.Order;

public class TaishanView {
	
	private Order condition;
	
	private List<Order> list;
	
	private Page page;

	private Order editInfo;

	public Order getCondition() {
		return condition;
	}

	public void setCondition(Order condition) {
		this.condition = condition;
	}

	public List<Order> getList() {
		return list;
	}

	public void setList(List<Order> list) {
		this.list = list;
	}
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Order getEditInfo() {
		return editInfo;
	}

	public void setEditInfo(Order editInfo) {
		this.editInfo = editInfo;
	}

	@Override
	public String toString() {
		return "TaishanView [condition=" + condition + ", list=" + list
				+ ", page=" + page + ", editInfo=" + editInfo + "]";
	}
	
	
	
}
