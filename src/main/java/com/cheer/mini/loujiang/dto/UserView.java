package com.cheer.mini.loujiang.dto;

import java.util.List;

import com.cheer.mini.ums.model.User;


public class UserView {
	
	private List<User> list;
	
	private User editInfo;
	
	private User accountCondition;

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

	public User getAccountCondition() {
		return accountCondition;
	}

	public void setAccountCondition(User accountCondition) {
		this.accountCondition = accountCondition;
	}

	@Override
	public String toString() {
		return "UserView [list=" + list + ", editInfo=" + editInfo + ", accountCondition=" + accountCondition + "]";
	}


	
	
}
