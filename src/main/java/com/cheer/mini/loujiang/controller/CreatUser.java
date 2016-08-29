package com.cheer.mini.loujiang.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.cheer.mini.base.model.ResultEntity;
import com.cheer.mini.base.model.ResultEntityHashMapImpl;
import com.cheer.mini.loujiang.dto.UserView;
import com.cheer.mini.ums.dto.request.CustomerUserCreateRequest;
import com.cheer.mini.ums.model.User;
import com.cheer.mini.ums.service.UserService;

@Controller
@RequestMapping("/loujiang")
public class CreatUser {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private UserService userService;

	@RequestMapping("/list")
	public String list(@ModelAttribute("view") UserView view, Model model) {
		logger.info("Input Param [list view] ->" + view);
		if (view == null) {
			view = new UserView();
		}
		if (view.getAccountCondition() == null) {
			view.setAccountCondition(new User());
			view.getAccountCondition().setAccountTypeFk(-1);
		}

		List<User> list = userService.listUser(view.getAccountCondition());
		logger.info("Input Param [list的值为] ->"+list.toString());
		view.setList(list);
		model.addAttribute("view", view);
		return "loujiang/list";

	}

	@RequestMapping("/info")
	public String info(@ModelAttribute UserView view, Model model) {
		logger.info("Input Param [info view] -> " + view);
		if (view.getEditInfo() != null && view.getEditInfo().getId() != null && view.getEditInfo().getId() != "") {
			User userInfo = userService.info(view.getEditInfo().getId());
			view.setEditInfo(userInfo);
		}
		model.addAttribute("view", view);
		return "loujiang/info";

	}
	
	@RequestMapping("/delete")
	public String delet(@ModelAttribute UserView view,Model model){
		logger.info("Input Param [view] -> " + view);
		
		if(view.getList()!=null
				&& !view.getList().isEmpty()){
			for(User selectUser:view.getList()){
				if(selectUser.getSelected()){
					String userId=selectUser.getId();
					userService.deleteByPrimaryKey(userId);
				}
			}
		}
		return list(view, model);
	}
	
	
	@RequestMapping("/update")
	public String update(@ModelAttribute UserView view,Model model){
		logger.info("Input Param [view] -> " + view);
		if(view.getEditInfo()!=null && 
				view.getEditInfo().getId()!=null
				&& view.getEditInfo().getId()!=""){
		userService.updateByPrimaryKey(view.getEditInfo());
		}
		return list(view, model);
	};
	
	@RequestMapping("/insterUsers")
	public ModelAndView insterUsers(final HttpServletRequest request,final HttpServletResponse response){
		logger.info("Input Param [] -> 进入insterUsers方法");
		
		ModelAndView mv = new ModelAndView("loujiang/register");
		return mv;
	}
	/***
	@RequestMapping("/register")
	public ResponseEntity<ResultEntity> register(final HttpServletRequest request, final HttpServletResponse response,@RequestBody CustomerUserCreateRequest userParam){
		
		logger.info("Input Param [view] -> 进入register方法"+userParam.toString());
		
		ResultEntity result = null;
		int user = userService.createUser(userParam);
		logger.info("Input Param [view] -> 在register方法中插入user"+user);
		result = new ResultEntityHashMapImpl(ResultEntity.KW_STATUS_SUCCESS,"注册成功", user);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<ResultEntity>(result, headers,HttpStatus.CREATED);
		
	}
	***/
}
