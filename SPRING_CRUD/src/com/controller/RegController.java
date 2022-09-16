package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DAO.RegDAO;
import com.VO.RegVO;

@Controller
public class RegController {

	@Autowired
	private RegDAO d1;

	@RequestMapping(value = "load.html", method = RequestMethod.GET)
	public ModelAndView Load() {
		return new ModelAndView("Registration", "data", new RegVO());

	}

	@RequestMapping(value = "insert.html", method = RequestMethod.POST)
	public ModelAndView Insert(@ModelAttribute RegVO regVo, @RequestParam int id) {
		
		regVo.setId(id);
		d1.insert(regVo);
		return new ModelAndView("redirect:/search.html");

	}

	@RequestMapping(value = "search.html", method = RequestMethod.GET)
	public ModelAndView Search() {
		
		List ls = d1.search();
		return new ModelAndView("Search", "SearchList", ls);

	}

	@RequestMapping(value = "delete.html", method = RequestMethod.GET)
	public ModelAndView Delete(@ModelAttribute RegVO regVO, @RequestParam int Id) {

		regVO.setId(Id);
		d1.delete(regVO);

		List ls = d1.search();
		return new ModelAndView("Search", "SearchList", ls);

	}

	@RequestMapping(value = "edit.html", method = RequestMethod.GET)
	public ModelAndView Edit(@ModelAttribute RegVO regVO, @RequestParam int Id) {

		regVO.setId(Id);
		List ls1 = d1.edit(regVO);
		return new ModelAndView("Registration", "data", ls1.get(0));

	}

}
