package com.cheer.mini.ums.service;

import java.util.List;

import com.cheer.mini.base.Page;
import com.cheer.mini.ums.model.Order;

public interface OrderService {
	
	
	public void save(Order orderInfo);
	
	public void update(Order orderInfo);
	
	public List<Order> list(Order condition);
	
	public Order info(String orderId);
	
	public void delete(String orderId);

	Integer count(Order condition);

	List<Order> list(Order condition, Page page);
	
}
