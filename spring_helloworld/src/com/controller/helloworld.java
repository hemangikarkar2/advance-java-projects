package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class helloworld {

	@RequestMapping(value="helloworld.html",method=RequestMethod.GET)
	
	public ModelAndView load(){
		String Message="Hello World!!!!!";
		return new ModelAndView("helloworld","Message",Message);
		
	}
	
}
