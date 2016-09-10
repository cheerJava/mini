package com.cheer.mini.ums.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cheer.mini.base.model.ResultEntity;
import com.cheer.mini.base.model.ResultEntityHashMapImpl;
import com.cheer.mini.ums.model.User;
import com.cheer.mini.ums.service.UserService;

@Controller
@RequestMapping("/ums/admin")
public class AdminManagementContorll {

	@Autowired
	private UserService userService;

	@RequestMapping("adminlist")
	public ModelAndView index(final HttpServletRequest request,
			final HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("ums/admin");
		return mv;
	}

//	@RequestMapping("/searchAdminlist")
//	public ResponseEntity<ResultEntity> searchAdminlist() {
//		ResultEntity result = null;
//		List<User> userlist = userService.listUser();
//		result = new ResultEntityHashMapImpl(ResultEntity.KW_STATUS_SUCCESS,
//				"成功", userlist);
//		HttpHeaders headers = new HttpHeaders();
//		return new ResponseEntity<ResultEntity>(result, headers,
//				HttpStatus.CREATED);
//	}
}
