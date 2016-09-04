package com.cheer.mini.loujiang.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.cheer.mini.base.Page;
import com.cheer.mini.base.exception.ServiceException;
import com.cheer.mini.base.model.ResultEntity;
import com.cheer.mini.base.model.ResultEntityHashMapImpl;
import com.cheer.mini.loujiang.dto.UserView;
import com.cheer.mini.ums.model.User;
import com.cheer.mini.loujiang.service.UserService;

@Controller
@RequestMapping("/loujiang")

public class UserController {
	private Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	private UserService userService;

	@RequestMapping("/userShow")
	public String list(@ModelAttribute UserView view, Model model) {
		logger.info("Input Param [view]->" + view);
		System.out.println("进入了》》》》》userShow方法");
		if (view == null) {
			view = new UserView();
		}
		if (view.getPage() == null) {
			Page page = new Page();
			page.setPageNo(1);
			view.setPage(page);
		}
		Integer total = userService.count(view.getCondition());
		view.getPage().cal(total);
		List<User> userlist = userService.listUser(view.getPage());
		view.setList(userlist);
		model.addAttribute("view", view);
		System.out.println("userShow方法》》》》》执行完毕");
		return "loujiang/userList";
	}

	@RequestMapping("/listByFk")
	public String listByVaild(@ModelAttribute UserView view, Model model) {
		logger.info("Input Param [view] -> " + view);
		System.out.println("进入了》》》》》listByFk(用户组查询)方法");
		if (view.getCondition() == null) {
			view.setCondition(new User());
			view.getCondition().setAccountTypeFk(200);
		}
		List<User> list = userService.list(view.getCondition());
		view.setList(list);
		model.addAttribute("view", view);
		System.out.println("listByFk方法》》》》》执行完毕");
		return "loujiang/userList";
	};

	@RequestMapping("/listByAccount")
	public String listByAccount(@ModelAttribute UserView view, Model model) throws ServiceException {
		logger.info("Input Param [view] -> " + view);
		System.out.println("进入了》》》》》listByAccount(通过账号模糊查询)方法");
		List<User> list = userService.listByAccount(view.getCondition());
		if (list.isEmpty())
			throw new ServiceException("您查找的用户不存在");
		view.setList(list);
		model.addAttribute("view", view);
		System.out.println("listByAccount方法》》》》》执行完毕");
		return "loujiang/userList";
	};

	@RequestMapping("/userinfo")
	public String userinfo(@ModelAttribute UserView view, Model model) {
		logger.info("Input Param [view] -> " + view);
		System.out.println("进入了》》》》》userinfo方法");
		if (view.getEditInfo() != null && view.getEditInfo().getId() != null && view.getEditInfo().getId() != "") {
			User userInfo = userService.selectByPrimaryKey(view.getEditInfo().getId());
			view.setEditInfo(userInfo);
		}
		model.addAttribute("view", view);
		System.out.println("userinfo方法》》》》》执行完毕");
		return "loujiang/userinfo";
	}

	@RequestMapping("/update")
	public String update(@ModelAttribute UserView view, Model model) {
		logger.info("Input Param [view] -> " + view);
		System.out.println("进入了》》》》》update（用户信息更新）方法");
		if (view.getEditInfo() != null && view.getEditInfo().getId() != null && view.getEditInfo().getId() != "") {
			System.out.println(view.getEditInfo().getPassword());
			userService.updateByPrimaryKeySelective(view.getEditInfo());
		}
		System.out.println("update方法》》》》》执行完毕");
		return list(view, model);
	}

	@RequestMapping("/delete")
	public String delete(@ModelAttribute UserView view, Model model) {
		logger.info("Input Param [view] -> " + view);
		System.out.println("进入了》》》》》delete方法");
		if (view.getList() != null && !view.getList().isEmpty()) {
			for (User selectUser : view.getList()) {
				if (selectUser.getSelected()) {
					String userId = selectUser.getId();
					userService.delete(userId);
				}

			}
		}
		System.out.println("delete方法》》》》》执行完毕");
		return list(view, model);
	}

	@RequestMapping("/register")
	public String register(@ModelAttribute UserView view, Model model) {
		model.addAttribute("view", view);
		return "loujiang/register";
	}

	@RequestMapping(value = "/validateregister")
	public ResponseEntity<ResultEntity> validateregister(@RequestBody User userParam, Model model,
			UriComponentsBuilder builder) throws ServiceException, Exception {
		logger.info("Input Param [view] -> " + userParam);
		System.out.println("进入了》》》》》validateregister（注册）方法");
		ResultEntity result = null;
		User user = userService.insertcreatUser(userParam);
		result = new ResultEntityHashMapImpl(ResultEntity.KW_STATUS_SUCCESS, "注册成功", user);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/loujiang/validateregister").buildAndExpand().toUri());
		System.out.println("validateregister方法》》》》》执行完毕");
		return new ResponseEntity<ResultEntity>(result, headers, HttpStatus.CREATED);
	}

}