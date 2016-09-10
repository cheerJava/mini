package com.cheer.mini.loujiang.dto;

import java.util.List;

import com.cheer.mini.base.Page;
import com.cheer.mini.ums.model.Order;
import com.cheer.mini.ums.model.User;



public class UserView {
	
	private User condition;
	
	private List<User> list;
	
	private User editInfo;

	private Page page;
	

	public User getCondition() {
		return condition;
	}



	public void setCondition(User condition) {
		this.condition = condition;
	}



	public List<User> getList() {
		return list;
	}



	public void setList(List<User> list) {
		this.list = list;
	}



	public User getEditInfo() {
		return editInfo;
	}



	public void setEditInfo(User editInfo) {
		this.editInfo = editInfo;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "UserView [condition=" + condition + ", list=" + list + ", editInfo=" + editInfo + ", page=" + page
				+ "]";
	}
	
}
