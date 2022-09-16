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

import com.DAO.RegDAO;
import com.VO.LoginVO;
import com.VO.RegisterVO;

@Controller
public class RegController {

	@Autowired
	RegDAO regDAO;

	@RequestMapping(value = "register.html", method = RequestMethod.GET)
	public ModelAndView load() {

		return new ModelAndView("Registration", "data", new RegisterVO());
	}

	@RequestMapping(value = "insert.html", method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute LoginVO loginVO, @ModelAttribute RegisterVO regVO) {
		
		loginVO.setUserName(regVO.getLoginVO().getUserName());
		loginVO.setPassword(regVO.getLoginVO().getPassword());

		this.regDAO.insertLogin(loginVO);

		regVO.setLoginVO(loginVO);
		this.regDAO.insertRegister(regVO);
		return new ModelAndView("redirect:/register.html");
	}

	@RequestMapping(value = "search.html", method = RequestMethod.GET)
	public ModelAndView search() {
		List searchList = new ArrayList();
		System.out.println("SearchList Size()=" + searchList.size());
		searchList = this.regDAO.searchRegister();
		return new ModelAndView("Search", "searchList", searchList);
	}
	
	@RequestMapping(value = "delete.html", method = RequestMethod.GET)
	public ModelAndView delete(@ModelAttribute RegisterVO registerVO,@ModelAttribute LoginVO loginVO,@RequestParam int rid,@RequestParam int lid) {
		
			loginVO.setId(lid);
			registerVO.setId(rid);
			registerVO.setLoginVO(loginVO);
			regDAO.deleteRegister(registerVO);
			regDAO.deleteLogin(loginVO);
		
		return new ModelAndView("redirect:/search.html");
	}

	@RequestMapping(value = "edit.html", method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute RegisterVO registerVO,@ModelAttribute LoginVO loginVO,@RequestParam int rid,@RequestParam int lid) {
		
			loginVO.setId(lid);
			registerVO.setId(rid);
			registerVO.setLoginVO(loginVO);
			List editRegList = regDAO.editRegister(registerVO);
			List editLoginList = regDAO.editLogin(loginVO);
			
		return new ModelAndView("Registration", "data",editRegList.get(0)).addObject("editLoginList",editLoginList.get(0));
	}

}
