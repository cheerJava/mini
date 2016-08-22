package com.cheer.mini.ums.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.cheer.mini.base.Constants;
import com.cheer.mini.base.model.BaseEntity;
import com.cheer.mini.base.model.ResultEntity;
import com.cheer.mini.base.model.ResultEntityHashMapImpl;
import com.cheer.mini.ums.dto.request.CustomerUserCreateRequest;
import com.cheer.mini.ums.dto.request.LoginRequest;
import com.cheer.mini.ums.dto.request.registerRequest;
import com.cheer.mini.ums.model.User;
import com.cheer.mini.ums.service.UserService;
import com.mysql.fabric.xmlrpc.base.Data;

//@Controller
//@RequestMapping("/ums/creat")
public class CreatUser {

	@Autowired
	private UserService userService;

	@RequestMapping("/register")
	public ModelAndView register(final HttpServletRequest request,
			final HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("ums/register");
		return mv;
	}

	@RequestMapping("/register2")
	public ModelAndView register2(final HttpServletRequest request,
			final HttpServletResponse response,
			@RequestBody CustomerUserCreateRequest customerUserCreateRequest) {
		System.out.println("fangfa");
		System.out.println(customerUserCreateRequest.getGender());
		userService.createUser(customerUserCreateRequest);
		ModelAndView mv = new ModelAndView("ums/index");
		return mv;
	}

}
