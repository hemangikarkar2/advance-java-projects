package com.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.RegDAO;
import com.Vo.LoginVO;
import com.Vo.RegisterVO;
import com.mysql.fabric.xmlrpc.base.Value;

import com.sun.java_cup.internal.runtime.virtual_parse_stack;

@Controller
public class RegController {
	@Autowired
	RegDAO regDAO;
	
	@RequestMapping(value="register.html", method=RequestMethod.GET)
	public ModelAndView load(){
		
		return new ModelAndView("Register","Data",new RegisterVO());
		
	}
	@RequestMapping(value="insert.html",method=RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute LoginVO loginVO,@ModelAttribute RegisterVO registerVO)
	{
		loginVO.setUserName(registerVO.getLoginVO().getUserName());
		loginVO.setPassword(registerVO.getLoginVO().getPassword());
		
		this.regDAO.insertLogin(loginVO);
		
		registerVO.setLoginVO(loginVO);
		this.regDAO.insertRegister(registerVO);
		
		return new ModelAndView("redirect:/register.html");
	}
	@RequestMapping(value="search.html",method=RequestMethod.GET)
	public ModelAndView search(){
		List searchList = new ArrayList();
		searchList =this.regDAO.searchRegister();
		return new ModelAndView("Search","searchList",searchList);
		
	}
	@RequestMapping(value="delete.html",method=RequestMethod.GET)
	public ModelAndView delete(@ModelAttribute RegisterVO registerVO,@ModelAttribute LoginVO loginVO,@RequestParam int rdid, @RequestParam int ldid)
	{
		loginVO.setId(ldid);
		registerVO.setId(rdid);
		registerVO.setLoginVO(loginVO);
		regDAO.deleteRegister(registerVO);
		regDAO.deleteLogin(loginVO);
		
		return new ModelAndView("redirect:/search.html");
		
	}
	@RequestMapping(value="edit.html",method=RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute RegisterVO registerVO,@ModelAttribute LoginVO loginVO,@RequestParam int reid,@RequestParam int leid ){
			loginVO.setId(leid);
			registerVO.setId(reid);
			registerVO.setLoginVO(loginVO);
			
			List editRegList =regDAO.editRegister(registerVO);
			List editLoginList =regDAO.editLogin(loginVO);
			return new ModelAndView("Register","Data",editRegList.get(0)).addObject("editLoginList",editLoginList.get(0));
		
	}
}
