package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Hello {

	@RequestMapping(value="hello.html",method=RequestMethod.GET)
	public ModelAndView load()
	{
		String Msg="Hello World!!!!!";
		return new ModelAndView("Hello","Msg",Msg);
	}
}
