package com.cheer.mini.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/demo")
public class DemoController {
	
	  @RequestMapping(value = "/portal")
	    public ModelAndView portal(final HttpServletRequest request, final HttpServletResponse response) {     
	        // --------------------------------------------------------------------------------------------
	        ModelAndView mv = new ModelAndView("demo/portal");
	       
	        // --------------------------------------------------------------------------------------------
	        return mv;
	    }
	  
	  @RequestMapping(value = "/form")
	    public ModelAndView form(final HttpServletRequest request, final HttpServletResponse response) {     
	        // --------------------------------------------------------------------------------------------
	        ModelAndView mv = new ModelAndView("demo/form");
	       
	        // --------------------------------------------------------------------------------------------
	        return mv;
	    }

}
