package com.cheer.mini.ums.dao;

import com.cheer.mini.ums.model.Order;
import com.cheer.mini.ums.model.User;

public interface OrderDao {
	public Order getOrderInfo(String orderId);
	
	public int save(Order order);
	
}
