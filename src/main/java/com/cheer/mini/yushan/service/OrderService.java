package com.cheer.mini.yushan.service;

import java.util.List;

import com.cheer.mini.base.Page;
import com.cheer.mini.ums.model.Order;

public interface OrderService {
	

	public void save(Order orderInfo);
	
	public List<Order> list(Order condition,Page page);

	public Integer count(Order condition);
	
	public Order info(String orderId);
	
	public void delete(String orderId);
	
	public void update(Order orderInfo);
	
	

}
