package com;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	

	@RequestMapping(value="login.html",method=RequestMethod.GET)
	public ModelAndView Load()
	{
			return new ModelAndView("Login");	
	
	}

	@RequestMapping(value="check.html",method=RequestMethod.POST)
	
	public ModelAndView check(HttpServletRequest request)
	{
		String username=request.getParameter("un");
		String password=request.getParameter("pwd");
		
		if(username.equals("admin") && password.equals("admin"))
		{	
			return new ModelAndView("LoginWelcome");
		}
		else
		{
			return new ModelAndView("Login");	
		}
	
	}

}
