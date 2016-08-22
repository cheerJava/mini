package com.cheer.mini.ums.service.serviceImpl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cheer.mini.base.util.StringUtil;
import com.cheer.mini.ums.dao.OrderDao;
import com.cheer.mini.ums.dao.OrderItemDao;
import com.cheer.mini.ums.model.Order;
import com.cheer.mini.ums.model.OrderItem;
import com.cheer.mini.ums.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderItemDao orderItemDao;
	
	private static String ADMIN_ID="ADMIN1E35D8911E68C9F3C970ED7EF76";
	
	@Override
	@Transactional
	public void save(Order orderInfo) {
		logger.info("Input Param [orderInfo] -> " + orderInfo );
		orderInfo.setId(StringUtil.createUUID());
		orderInfo.setCreatorFk(ADMIN_ID);
		orderInfo.setUpdaterFk(ADMIN_ID);
		orderInfo.setDateCreate(new Date());
		orderInfo.setDateUpdate(new Date());
		orderDao.save(orderInfo);
		if(orderInfo.getItems()!=null 
				&& !orderInfo.getItems().isEmpty()){
			for(int i=0;i<orderInfo.getItems().size();i++){
				OrderItem item = orderInfo.getItems().get(i);
				item.setId(StringUtil.createUUID());
				item.setOrderId(orderInfo.getId());
				orderItemDao.save(item);
			}
		}
	}
	
	/***
	public void commonProcess(){
		
	}
	**/
	
}
