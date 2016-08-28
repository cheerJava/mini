package com.cheer.mini.ums.dao;

import com.cheer.mini.ums.model.OrderItem;

public interface OrderItemDao {
	public int save(OrderItem orderItem);
	
	public int deleteByOrderId(String orderId);
	
	public int update(OrderItem orderItem);
}
