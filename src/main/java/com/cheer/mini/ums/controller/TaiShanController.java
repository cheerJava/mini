package com.cheer.mini.ums.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cheer.mini.ums.dto.TaishanView;
import com.cheer.mini.ums.model.Order;
import com.cheer.mini.ums.model.OrderItem;
import com.cheer.mini.ums.model.User;

@Controller
@RequestMapping("/taishan")
public class TaiShanController {
	
	private Logger logger = Logger.getLogger(getClass());
	
	private static List<Order> orderList = new ArrayList<Order>();
	
	static{
		{
			Order orderInfo = new Order();
			orderInfo.setId("1");
	    	orderInfo.setTitle("Uter's Order");
	    	orderInfo.setAmount(new BigDecimal("180.00").
	    			setScale(2, BigDecimal.ROUND_HALF_UP));
	        
	    	List<OrderItem> items = new ArrayList<OrderItem>();
	    	
	    	{
		    	OrderItem item = new OrderItem();
		    	item.setProductName("苹果");
		    	item.setNumber(3);
		    	item.setPrice(new BigDecimal("10"));
		    	items.add(item);
	    	}
	    	
	    	{
		    	OrderItem item = new OrderItem();
		    	item.setProductName("香蕉");
		    	item.setNumber(5);
		    	item.setPrice(new BigDecimal("20"));
		    	items.add(item);
	    	}
	    	
	    	{
		    	OrderItem item = new OrderItem();
		    	item.setProductName("西瓜");
		    	item.setNumber(2);
		    	item.setPrice(new BigDecimal("30"));
		    	items.add(item);
	    	}
	    	
	    	orderInfo.setItems(items);
	    	orderList.add(orderInfo);
		}
		
		
		{
			Order orderInfo = new Order();
			orderInfo.setId("2");
	    	orderInfo.setTitle("Uter1's Order");
	    	orderInfo.setAmount(new BigDecimal("180.00").
	    			setScale(2, BigDecimal.ROUND_HALF_UP));
	    	orderInfo.setStatus(Order.ORDER_STATUS.COMMIT);
	        
	    	List<OrderItem> items = new ArrayList<OrderItem>();
	    	
	    	{
		    	OrderItem item = new OrderItem();
		    	item.setProductName("苹果");
		    	item.setNumber(3);
		    	item.setPrice(new BigDecimal("10"));
		    	items.add(item);
	    	}
	    	
	    	{
		    	OrderItem item = new OrderItem();
		    	item.setProductName("香蕉");
		    	item.setNumber(5);
		    	item.setPrice(new BigDecimal("20"));
		    	items.add(item);
	    	}
	    	
	    	{
		    	OrderItem item = new OrderItem();
		    	item.setProductName("西瓜");
		    	item.setNumber(2);
		    	item.setPrice(new BigDecimal("30"));
		    	items.add(item);
	    	}
	    	
	    	orderInfo.setItems(items);
	    	orderList.add(orderInfo);
		}
		
		{
			Order orderInfo = new Order();
			orderInfo.setId("3");
	    	orderInfo.setTitle("Uter2's Order");
	    	orderInfo.setAmount(new BigDecimal("180.00").
	    			setScale(2, BigDecimal.ROUND_HALF_UP));
	    	orderInfo.setStatus(Order.ORDER_STATUS.PAYMENT);
	    	List<OrderItem> items = new ArrayList<OrderItem>();
	    	
	    	{
		    	OrderItem item = new OrderItem();
		    	item.setProductName("苹果");
		    	item.setNumber(3);
		    	item.setPrice(new BigDecimal("10"));
		    	items.add(item);
	    	}
	    	
	    	{
		    	OrderItem item = new OrderItem();
		    	item.setProductName("香蕉");
		    	item.setNumber(5);
		    	item.setPrice(new BigDecimal("20"));
		    	items.add(item);
	    	}
	    	
	    	{
		    	OrderItem item = new OrderItem();
		    	item.setProductName("西瓜");
		    	item.setNumber(2);
		    	item.setPrice(new BigDecimal("30"));
		    	items.add(item);
	    	}
	    	
	    	orderInfo.setItems(items);
	    	orderList.add(orderInfo);
		}
		
		{
			Order orderInfo = new Order();
			orderInfo.setId("4");
	    	orderInfo.setTitle("Uter3's Order");
	    	orderInfo.setAmount(new BigDecimal("180.00").
	    			setScale(2, BigDecimal.ROUND_HALF_UP));
	    	orderInfo.setStatus(Order.ORDER_STATUS.PAYMENT);
	    	List<OrderItem> items = new ArrayList<OrderItem>();
	    	
	    	{
		    	OrderItem item = new OrderItem();
		    	item.setProductName("苹果");
		    	item.setNumber(3);
		    	item.setPrice(new BigDecimal("10"));
		    	items.add(item);
	    	}
	    	
	    	{
		    	OrderItem item = new OrderItem();
		    	item.setProductName("香蕉");
		    	item.setNumber(5);
		    	item.setPrice(new BigDecimal("20"));
		    	items.add(item);
	    	}
	    	
	    	{
		    	OrderItem item = new OrderItem();
		    	item.setProductName("西瓜");
		    	item.setNumber(2);
		    	item.setPrice(new BigDecimal("30"));
		    	items.add(item);
	    	}
	    	
	    	orderInfo.setItems(items);
	    	orderList.add(orderInfo);
		}
	}
	
	@RequestMapping("/list")
	public String list(@ModelAttribute("view") TaishanView view,Model model){
		logger.info("Input Param [view] -> " + view);
		if(view == null){
			view = new TaishanView();
		}
		if(view.getCondition()==null){
			view.setList(orderList);
		}else{
			List<Order> _orderList = new ArrayList<Order>();
			for(int i=0;i<orderList.size();i++){
				Order order = orderList.get(i);	
				boolean watchFlag = false;
				//String conditionTitle = view.getCondition().getTitle();
				int conditionStatus = view.getCondition().getStatus();
				if(conditionStatus ==-1 ){
					watchFlag = true;
				}
				
				if(!watchFlag && conditionStatus == order.getStatus()){
					watchFlag = true;
				}
				if(watchFlag){
					_orderList.add(order);
				}
			}
			view.setList(_orderList);
		}
		model.addAttribute("view", view);
		return "taishan/list";
	};
	
	@RequestMapping("/info")
	public String info(@ModelAttribute TaishanView view,Model model){
		logger.info("Input Param [view] -> " + view);
		if(view.getEditInfo()!=null && 
				view.getEditInfo().getId()!=null
				&& view.getEditInfo().getId()!=""){
			for(int i=0;i<orderList.size();i++){
				Order order = orderList.get(i);
				if(order.getId().equals(view.getEditInfo().getId())){
					view.setEditInfo(order);
					break;
				}
			}
		}
		model.addAttribute("view", view);
		return "taishan/info";
	};
	
	@RequestMapping("/save")
	public String save(@ModelAttribute TaishanView view ,Model model ){
		logger.info("Input Param [view] -> " + view);
		//TODO CALL DAO SAVE METHOD
		if(view.getEditInfo()!=null && 
				view.getEditInfo().getId()!=null
				&& view.getEditInfo().getId()!=""){
			for(int i=0;i<orderList.size();i++){
				Order order = orderList.get(i);
				if(order.getId().equals(view.getEditInfo().getId())){
					orderList.set(i,view.getEditInfo());
					break;
				}
			}
		}
		return list(view, model);
	};
	
	@RequestMapping("/delete")
	public String delet(@ModelAttribute TaishanView view, Model model){
		logger.info("Input Param [view] -> " + view);
		if(view.getList()!=null 
				&& !view.getList().isEmpty()){
			for(Order selectOrder  : view.getList()){
				if(selectOrder.getSelected()){
					String id = selectOrder.getId();
					for(Iterator<Order> it = orderList.iterator();it.hasNext();){
						Order dataItem = it.next();
						if(dataItem.getId().equals(id)){
							it.remove();
						}
					}
				}
			}
		}
		return list(view, model);
	};
	
	
	
	
	
}
