package com.cheer.mini.yushan.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cheer.mini.base.Page;
import com.cheer.mini.ums.model.Order;
import com.cheer.mini.yushan.dto.OrderView;
import com.cheer.mini.yushan.service.OrderService;

@Controller
@RequestMapping("/yushan")
public class OrderController {
	
	private Logger logger=Logger.getLogger(getClass());
	
	@Autowired
	private OrderService orderService;

	@RequestMapping("/list")
	public String list(@ModelAttribute("view")OrderView view,Model model) {
		logger.info("input list Param[view]"+view);
		if(view==null){
			view=new OrderView();		
		}
		if(view.getCondition()==null){
			view.setCondition(new Order());
			view.getCondition().setStatus(-1);
		}
		if(view.getPage()==null){
			Page page=new Page();
			page.setPageNo(1);
			view.setPage(page);
		}
		Integer total=orderService.count(view.getCondition());
		view.getPage().cal(total);
		List<Order> list=orderService.list(view.getCondition(),view.getPage());
		view.setList(list);
		model.addAttribute("view", view);		
		return "/yushan/orderlist";

	};
	
	@RequestMapping("/info")
	public String info(@ModelAttribute("view")OrderView view,Model model){
		logger.info("input list Param[view]"+view);
		if(view.getEditInfo()!=null
				&&!view.getEditInfo().getId().isEmpty()
				&&view.getEditInfo().getId()!=""){
			Order orderInfo=orderService.info(view.getEditInfo().getId());
			view.setEditInfo(orderInfo);
		}
		model.addAttribute("view",view);
		return "/yushan/orderinfo";
		
	};
	@RequestMapping("/add")
	public String add(@ModelAttribute("view")OrderView view,Model model){
		logger.info("Input Param [view] -> " + view);
		view.setEditInfo(new Order());
		model.addAttribute("view", view);
		return "yushan/ordersave";
		
	};
	

	@RequestMapping("save")
	public String save(@ModelAttribute("view")OrderView view,Model model){
		logger.info("Input Param [view] -> " + view);	
		orderService.save(view.getEditInfo());
		return list(view, model);
		
	};
	
	@RequestMapping("/delete")
	public String delete(@ModelAttribute("view")OrderView view,Model model){
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
	
	@RequestMapping("update")
	public String update(@ModelAttribute("view")OrderView view,Model model){
		logger.info("Input Param [view] -> " + view);
		if(view.getEditInfo()!=null && 
				view.getEditInfo().getId()!=null
				&& view.getEditInfo().getId()!=""){
			orderService.update(view.getEditInfo());
		}
		return list(view, model);
		
	};
}
