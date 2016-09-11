package com.cheer.mini.ums.service.serviceImpl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cheer.mini.base.Page;
import com.cheer.mini.base.interceptors.LoginInterceptor;
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
		
	@Override
	@Transactional
	public void save(Order orderInfo) {
		if(orderInfo.getId() == null
				|| StringUtil.isEmpty(orderInfo.getId())){
			//TODO insert 
			logger.info("Order insert into");
			orderInfo.setId(StringUtil.createUUID());
			orderInfo.setCreatorFk(LoginInterceptor.getCurrentUser().getId());
			orderInfo.setUpdaterFk(LoginInterceptor.getCurrentUser().getId());
			orderInfo.setDateCreate(new Date());
			orderInfo.setDateUpdate(new Date());
			orderMapper.insert(orderInfo);
			if(orderInfo.getItems()!=null 
					&& !orderInfo.getItems().isEmpty()){
				for(int i=0;i<orderInfo.getItems().size();i++){
					OrderItem item = orderInfo.getItems().get(i);
					if(item!=null
							&& !StringUtil.isEmpty(item.getProductName())
							&& item.getPrice()!=null){
						item.setId(StringUtil.createUUID());
						item.setOrderId(orderInfo.getId());
						orderItemMapper.insert(item);
					}
				}
			}
		}else{
			logger.info("Order update");
			orderMapper.updateByPrimaryKeySelective(orderInfo);
			if(orderInfo.getItems()!=null
					&& !orderInfo.getItems().isEmpty()){
				
				OrderItemExample example = new OrderItemExample();
				example.createCriteria().andOrderIdEqualTo(orderInfo.getId());
				
				List<OrderItem> oldList = orderItemMapper.selectByExample(example);
				if(oldList!=null && !oldList.isEmpty()){
					for(int i=0;i<oldList.size();i++){
						OrderItem oldItem = oldList.get(i);
						orderItemMapper.deleteByPrimaryKey(oldItem.getId());
					}
				}
				for(int i=0;i<orderInfo.getItems().size();i++){
					OrderItem item = orderInfo.getItems().get(i);
					if(item!=null  
							&& !StringUtil.isEmpty(item.getProductName())
							&& item.getPrice()!=null){
						item.setId(StringUtil.createUUID());
						item.setOrderId(orderInfo.getId());
						orderItemMapper.insert(item);
					}
				}
			}
		}
		logger.info("Input Param [orderInfo] -> " + orderInfo );
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
	public Order info(String orderId) {
		Order rt = orderMapper.selectByPrimaryKey(orderId);
		OrderItemExample oie = new OrderItemExample();
		oie.createCriteria().andOrderIdEqualTo(orderId);
		List<OrderItem> items = orderItemMapper.selectByExample(oie);
		rt.setItems(items);
		return rt;
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
	
	/***
	public void commonProcess(){
		
	}
	**/
	
}
