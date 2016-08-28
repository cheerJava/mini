package com.cheer.mini.ums.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cheer.mini.ums.dto.TaishanView;
import com.cheer.mini.ums.model.Order;
import com.cheer.mini.ums.model.OrderItem;
import com.cheer.mini.ums.model.User;
import com.cheer.mini.ums.service.OrderService;

@Controller
@RequestMapping("/taishan")
public class TaiShanController {
	
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/list")
	public String list(@ModelAttribute("view") TaishanView view,Model model){
		logger.info("Input Param [view] -> " + view);
		if(view == null){
			view = new TaishanView();
		}
		if(view.getCondition()==null){
			view.setCondition(new Order());
			view.getCondition().setStatus(-1);
		}
		List<Order> list = orderService.list(view.getCondition());
		view.setList(list);
		model.addAttribute("view", view);
		return "taishan/list";
	};
	
	@RequestMapping("/info")
	public String info(@ModelAttribute TaishanView view,Model model){
		logger.info("Input Param [view] -> " + view);
		if(view.getEditInfo()!=null && 
				view.getEditInfo().getId()!=null
				&& view.getEditInfo().getId()!=""){
			Order orderInfo = orderService.info(view.getEditInfo().getId());
			view.setEditInfo(orderInfo);
		}
		model.addAttribute("view", view);
		return "taishan/info";
	};
	@RequestMapping("/save")
	public String save(@ModelAttribute TaishanView view ,Model model ){
		logger.info("Input Param [view] -> " + view);
		if(view.getEditInfo()!=null && 
				view.getEditInfo().getId()!=null
				&& view.getEditInfo().getId()!=""){
			orderService.update(view.getEditInfo());
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
					String orderId = selectOrder.getId();
					orderService.delete(orderId);
				}
			}
		}
		return list(view, model);
	};
	
	
	
	
	
}
