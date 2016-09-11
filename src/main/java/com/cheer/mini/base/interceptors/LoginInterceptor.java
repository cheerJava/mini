package com.cheer.mini.base.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cheer.mini.base.Constants;
import com.cheer.mini.ums.model.User;

public class LoginInterceptor implements HandlerInterceptor {

	private static ThreadLocal<User> operator = new ThreadLocal<User>();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (request.getSession().getAttribute(
				Constants.CURRENT_USER) == null) {
			request.getRequestDispatcher("/ums/user/login").
				forward(request, response);
			return false;
		}
		
		operator.set((User)request.getSession().getAttribute(
				Constants.CURRENT_USER));
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}
	
	public static User getCurrentUser(){
		return operator.get();
	}
	
}
