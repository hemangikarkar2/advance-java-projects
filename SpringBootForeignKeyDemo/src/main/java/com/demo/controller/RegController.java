package com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.dao.RegDAO;
import com.demo.model.LoginVO;
import com.demo.model.RegVO;
import com.demo.service.RegService;
import com.demo.service.RegServiceImp;

@Controller
public class RegController {
	
	@Autowired 
	private RegService regService;
	
	@GetMapping(value="/")
	public ModelAndView Load(){
	
		return new ModelAndView("register","Data",new RegVO());	
	} 
	
	@PostMapping(value="insert")
	public ModelAndView Insert(@ModelAttribute RegVO regVO,@ModelAttribute LoginVO  loginVO, @RequestParam int id){
	
		regVO.setStatus(true);
		
		
		//this.regService.insert(regVO);
		
		loginVO.setUserName(regVO.getLoginVO().getUserName());
		loginVO.setPassword(regVO.getLoginVO().getPassword());
		
		this.regService.insertLogin(loginVO);
		
		regVO.setLoginVO(loginVO);
		this.regService.insert(regVO);
		return new ModelAndView("redirect:/");
	}
	
	@GetMapping(value="search")
	public ModelAndView Search(){
		
		List searchList =new ArrayList();
		searchList= this.regService.searchRegister();
		
		return new ModelAndView("search","searchList",searchList);	
	}
	
}
