package com.cheer.mini.ums.dao;

import java.util.List;

import com.cheer.mini.ums.model.Order;

public interface OrderDao {
	public Order getOrderInfo(String orderId);
	
	public int save(Order order);
	
	public int update(Order order);
	
	public List<Order> list(Order condition);
	
	public int delete(String orderId);
	
}