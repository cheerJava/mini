package com.cheer.mini.base.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class DemoInterceptor implements HandlerInterceptor {
	
	
	private Logger logger = Logger.getLogger(getClass());
	
	private ThreadLocal<Long> startTime = new ThreadLocal<Long>();
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.info("preHandle()");
		startTime.set(System.currentTimeMillis());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("postHandle()");
		
		
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("afterCompletion()");
		
		long currTime = System.currentTimeMillis();
		long _startTime = startTime.get();
		long castTime = currTime - _startTime;
		logger.info("castTime :" + castTime);
	}
	

}
