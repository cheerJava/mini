package com.cheer.mini.ums.service.serviceImpl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cheer.mini.base.Page;
import com.cheer.mini.base.util.StringUtil;
import com.cheer.mini.ums.dao.OrderItemMapper;
import com.cheer.mini.ums.dao.OrderMapper;
import com.cheer.mini.ums.model.Order;
import com.cheer.mini.ums.model.OrderExample;
import com.cheer.mini.ums.model.OrderExample.Criteria;
import com.cheer.mini.ums.model.OrderItem;
import com.cheer.mini.ums.model.OrderItemExample;
import com.cheer.mini.ums.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderItemMapper orderItemMapper;
	
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
		orderMapper.insert(orderInfo);
		if(orderInfo.getItems()!=null 
				&& !orderInfo.getItems().isEmpty()){
			for(int i=0;i<orderInfo.getItems().size();i++){
				OrderItem item = orderInfo.getItems().get(i);
				item.setId(StringUtil.createUUID());
				item.setOrderId(orderInfo.getId());
				orderItemMapper.insert(item);
			}
		}
	}

	@Override
	public List<Order> list(Order condition) {
		OrderExample example = new OrderExample();
		Criteria criteria = example.createCriteria();
		if(condition!=null && StringUtil.notEmpty(condition.getTitle())){
			criteria.andTitleLike(condition.getTitle() + "%");
		}
		if(condition!=null && condition.getStatus()!=-1){
			criteria.andStatusEqualTo(new Byte(((byte)condition.getStatus())));
		}
		return orderMapper.selectByExample(example);
	}

	@Override
	public Order info(String orderId) {
		Order rt = orderMapper.selectByPrimaryKey(orderId);
		OrderItemExample oie = new OrderItemExample();
		oie.createCriteria().andOrderIdEqualTo(orderId);
		List<OrderItem> items = orderItemMapper.selectByExample(oie);
		rt.setItems(items);
		return rt;
	}
	
	@Override
	public Integer count(Order condition) {
		OrderExample example = new OrderExample();
		Criteria criteria = example.createCriteria();
		if(condition!=null && StringUtil.notEmpty(condition.getTitle())){
			criteria.andTitleLike(condition.getTitle() + "%");
		}
		if(condition!=null && condition.getStatus()!=-1){
			criteria.andStatusEqualTo(new Byte(((byte)condition.getStatus())));
		}
		return orderMapper.selectCountByExample(example);
	}
	
	@Override
	public List<Order> list(Order condition,Page page) {
		OrderExample example = new OrderExample();
		Criteria criteria = example.createCriteria();
		if(condition!=null && StringUtil.notEmpty(condition.getTitle())){
			criteria.andTitleLike(condition.getTitle() + "%");
		}
		if(condition!=null && condition.getStatus()!=-1){
			criteria.andStatusEqualTo(new Byte(((byte)condition.getStatus())));
		}
		if(page!=null){
			example.setPage(page);
		}
		return orderMapper.selectByExample(example);
	}

	@Override
	@Transactional
	public void delete(String orderId) {
		OrderItemExample oie = new OrderItemExample();
		oie.createCriteria().andOrderIdEqualTo(orderId);
		List<OrderItem> items = orderItemMapper.selectByExample(oie);
		if(items!=null && !items.isEmpty()){
			for(int i=0;i<items.size();i++){
				OrderItem item = items.get(i);
				orderItemMapper.deleteByPrimaryKey(item.getId());
			}
		}
		orderMapper.deleteByPrimaryKey(orderId);
	}

	@Override
	@Transactional
	public void update(Order orderInfo) {
		
		orderMapper.updateByPrimaryKey(orderInfo);
		if(orderInfo.getItems()!=null
				&& !orderInfo.getItems().isEmpty()){
			for(int i=0;i<orderInfo.getItems().size();i++){
				OrderItem item = orderInfo.getItems().get(i);
				orderItemMapper.updateByPrimaryKey(item);
				
			}
		}
	}
	
	/***
	public void commonProcess(){
		
	}
	**/
	
}
