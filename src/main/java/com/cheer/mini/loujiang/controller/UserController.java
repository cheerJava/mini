package com.cheer.mini.loujiang.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.cheer.mini.ums.dto.request.CustomerUserCreateRequest;
import com.cheer.mini.ums.model.User;
import com.cheer.mini.loujiang.service.UserService;

@Controller
@RequestMapping("/loujiang")
public class UserController {

	@Autowired
	private UserService userService;
	private Logger logger = Logger.getLogger(UserController.class);
	private static List<User> userList = new ArrayList<User>();

	@RequestMapping("/list")
	public String list(@ModelAttribute("view") UserView view, Model model) {
		logger.info("Input Param [view] -> " + view);
		if (view == null) {
			view = new UserView();
		}
		if(view.getPage()==null){
			Page page=new Page();
			page.setPageNo(1);
			view.setPage(page);
		}
		Integer total = userService.count(view.getCondition());
		view.getPage().cal(total);
		List<User> list = userService.list(view.getCondition());
		view.setList(list);
		model.addAttribute("view", view);
		return "/loujiang/list";

	}
	

	@RequestMapping("/search")
	public String search(@ModelAttribute UserView view, Model model) {
		logger.info("Input Param [view] -> " + view);
		if (view == null) {
			view = new UserView();
		}
		List<User> list = userService.list(view.getCondition());
		view.setList(list);
		model.addAttribute("view", view);
		return "/loujiang/search";

	}

	
	  @RequestMapping("/addjsp") public String addjsp(@ModelAttribute UserView
	  view,Model model){
	  
	  return "loujiang/register"; 
	  }
	  
	 
	 
	  @RequestMapping("/add") 
	  public ResponseEntity<ResultEntity> add(final HttpServletRequest request, final HttpServletResponse
	 response,@RequestBody CustomerUserCreateRequest
	  customerUserCreateRequest) { 
	System.out.println("fangfa"); 
	ResultEntity result = null; 
	System.out.println(customerUserCreateRequest.getGender());
	  int user = userService.createUser(customerUserCreateRequest); 
	  result = new ResultEntityHashMapImpl(ResultEntity.KW_STATUS_SUCCESS, "成功", user);
	  HttpHeaders headers = new HttpHeaders(); 
	  return new ResponseEntity<ResultEntity>(result, headers, HttpStatus.CREATED); 
	  }
	  
/*	  @RequestMapping("/register2")
	  public ResponseEntity<ResultEntity> register2(final HttpServletRequest request, final HttpServletResponse response,UriComponentsBuilder builder,@RequestBody CustomerUserCreateRequest customerUserCreateRequest) {
	  System.out.println("fangfa");
	  ResultEntity result = null;
	  System.out.println(customerUserCreateRequest.getGender());
	  int user = userService.createUser(customerUserCreateRequest);
	  result = new ResultEntityHashMapImpl(ResultEntity.KW_STATUS_SUCCESS, "成功", user);
      HttpHeaders headers = new HttpHeaders();
      System.out.println(result);
      headers.setLocation(builder.path("/loujiang/list")
				.buildAndExpand().toUri());
      return new ResponseEntity<ResultEntity>(result, headers, HttpStatus.CREATED); 
    }*/
	  

	@RequestMapping("/delete")
	public String delete(@ModelAttribute UserView view, Model model) {
		logger.info("Input Param [view] -> " + view);
		if (view.getList() != null && !view.getList().isEmpty()) {
			for (User selectUser : view.getList()) {
				if (selectUser.getSelected()) {
					String userId = selectUser.getId();
					userService.delete(userId);
				}
			}
		}

		return list(view, model);
	}

	@RequestMapping("/save")
	public String save(@ModelAttribute UserView view, Model model) {
		logger.info("Input Param [view] -> " + view);
		if (view.getEditInfo() != null && view.getEditInfo().getId() != null && view.getEditInfo().getId() != "") {
			userService.updateByPrimaryKeySelective(view.getEditInfo());
		}

		return list(view, model);
	}

	@RequestMapping("/info")
	public String info(@ModelAttribute UserView view, Model model) {
		logger.info("Input Param [view] -> " + view);
		if (view.getEditInfo() != null && view.getEditInfo().getId() != null && view.getEditInfo().getId() != "") {
			User userInfo = userService.selectByPrimaryKey(view.getEditInfo().getId());
			view.setEditInfo(userInfo);
		}
		model.addAttribute("view", view);
		return "loujiang/info";
	};

}
