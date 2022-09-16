package com;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class loginController {

	@RequestMapping(value="Login11.html",method=RequestMethod.GET)
	public ModelAndView Load(){
		
		return new ModelAndView("Login11");
	}
	
	@RequestMapping(value="check11.html",method=RequestMethod.POST)
	public ModelAndView Check(HttpServletRequest request)
	{
		String username=request.getParameter("un1");
		String password=request.getParameter("pwd1");
		if(username.equals("admin") && password.equals("admin"))
		{
			return new ModelAndView("LoginWelcome11");
		}
		else{
			return new ModelAndView("Login11");
		}
		
		
	}
}
