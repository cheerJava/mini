package com.cheer.mini.tinglin.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cheer.mini.base.Page;
import com.cheer.mini.tinglin.dto.ProductView;
import com.cheer.mini.tinglin.service.ProductService;
import com.cheer.mini.ums.model.Product;

@Controller
@RequestMapping("/tinglin")
public class TinglinController {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	ProductService proService;

	@RequestMapping("/list")
	public String list(@ModelAttribute("view") ProductView view, Model model) {
		logger.info("Input Param [view] -> " + view);
		if (view == null) {
			view = new ProductView();
		}
		if (view.getCondition() == null) {
			view.setCondition(new Product());
		}
		if (view.getPage() == null) {
			Page page = new Page();
			page.setPageNo(1);
			view.setPage(page);
		}
		Integer total = proService.count(view.getCondition());
		view.getPage().cal(total);
		List<Product> list1 = proService.list(view.getCondition(), view.getPage());
		view.setList(list1);
		model.addAttribute("view", view);
		return "tinglin/list";
	}

	@RequestMapping("/info")
	public String info(@ModelAttribute ProductView view, Model model) {
		logger.info("Input Param [view] -> " + view);
		if (view.getProInfo() != null && view.getProInfo().getId() != null && view.getProInfo().getId() != "") {
			Product proInfo = proService.info(view.getProInfo().getId());
			view.setProInfo(proInfo);
		}
		model.addAttribute("view", view);
		return "tinglin/info";
	};

	@RequestMapping("/update")
	public String save(@ModelAttribute ProductView view, Model model) {
		logger.info("Input Param [view] -> " + view);
		if (view.getProInfo() != null && view.getProInfo().getId() != null && view.getProInfo().getId() != "") {
			proService.update(view.getProInfo());
		}
		return list(view, model);
	};

	@RequestMapping("/delete")
	public String delet(@ModelAttribute ProductView view, Model model) {
		logger.info("Input Param [view] -> " + view);
		if (view.getList() != null && !view.getList().isEmpty()) {
			for (Product selectPro : view.getList()) {
				if (selectPro.getSelected()) {
					String proId = selectPro.getId();
					proService.delete(proId);
				}
			}
		}
		return list(view, model);
	};

	@RequestMapping("/add")
	public String add(@ModelAttribute ProductView view, Model model) {
		logger.info("Input Param [view] -> " + view);
		if (view.getProInfo() != null && view.getProInfo().getId() != null && view.getProInfo().getId() != "") {
			proService.save(view.getProInfo());
		}
		return list(view, model);
	};

	@RequestMapping("/index")
	public String index() {
		return "ums/index";
	}

}
