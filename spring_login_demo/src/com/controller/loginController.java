package com.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class loginController {

	@RequestMapping(value="login12.html",method=RequestMethod.GET)

	public ModelAndView load() {
		
		return new ModelAndView("login");
	}

	@RequestMapping(value="check12.html",method=RequestMethod.POST)

	public ModelAndView check(HttpServletRequest request) {
		
		String username = request.getParameter("un");
		String password = request.getParameter("pwd");

		if (username.equals("admin") && password.equals("admin")) {
			
			return new ModelAndView("loginWelcome");
		} 
		else {
			
			return new ModelAndView("login");
		}
	}
}
