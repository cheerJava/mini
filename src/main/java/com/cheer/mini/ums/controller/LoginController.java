package com.cheer.mini.ums.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.cheer.mini.base.Constants;
import com.cheer.mini.base.exception.ServiceException;
import com.cheer.mini.base.model.ResultEntity;
import com.cheer.mini.base.model.ResultEntityHashMapImpl;
import com.cheer.mini.ums.dto.request.CustomerUserCreateRequest;
import com.cheer.mini.ums.dto.request.LoginRequest;
import com.cheer.mini.ums.model.User;
import com.cheer.mini.ums.service.UserService;

@Controller
@RequestMapping("/ums/user")
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public ModelAndView login(final HttpServletRequest request,
			final HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("ums/login");
		return mv;
	}

	@RequestMapping(value = "/validatelogin")
	public ResponseEntity<ResultEntity> validateLogin(
			final HttpServletRequest request,
			@RequestBody LoginRequest loginRequest, UriComponentsBuilder builder)
			throws ServiceException, Exception {
		ResultEntity result = null;
		User user = userService.adminLogin(loginRequest.getAccount(),
				loginRequest.getPassword());
		request.getSession().setAttribute(Constants.CURRENT_USER, user);
		result = new ResultEntityHashMapImpl(ResultEntity.KW_STATUS_SUCCESS,
				"登录成功", user);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/ums/user/validatelogin")
				.buildAndExpand().toUri());
		return new ResponseEntity<ResultEntity>(result, headers,
				HttpStatus.CREATED);
	}

	@RequestMapping("/logout")
	public ModelAndView logout(final HttpServletRequest request,
			final HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("ums/login");
		request.getSession().removeAttribute(Constants.CURRENT_USER);
		return mv;
	}

	@RequestMapping("/index")
	public ModelAndView index(final HttpServletRequest request,
			final HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("ums/index");
		return mv;
	}

}
