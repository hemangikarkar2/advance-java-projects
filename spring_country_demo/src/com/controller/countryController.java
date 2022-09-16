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

import com.Vo.countryVo;
import com.Vo.stateVo;
import com.dao.countryDao;
import com.dao.stateDao;

@Controller
public class countryController {

	@Autowired
	private countryDao countrydao1;

	@RequestMapping(value = "load1.html", method = RequestMethod.GET)

	public ModelAndView Load() {
		return new ModelAndView("country", "Data", new countryVo());

	}

	@RequestMapping(value = "insert.html", method = RequestMethod.POST)

	public ModelAndView Insert(@ModelAttribute countryVo countryVo, @RequestParam int countryId) {
		countryVo.setCountryId(countryId);
		countryVo.setStatus(true);
		countrydao1.insertCountry(countryVo);

		return new ModelAndView("redirect:/search1.html");

	}

	@RequestMapping(value = "search1.html", method = RequestMethod.GET)
	public ModelAndView Search() {
		List searchList = countrydao1.searchCountry();
		return new ModelAndView("searchcountry", "searchList", searchList);

	}

	@RequestMapping(value = "delete.html", method = RequestMethod.GET)
	public ModelAndView Delete(@ModelAttribute countryVo countryVo, stateVo stateVo, @RequestParam int id,
			HttpServletRequest request) {

		countryVo.setCountryId(id);
		List deleteList = countrydao1.editCountry(countryVo);
		countryVo countryvo2 = (com.Vo.countryVo) deleteList.get(0);
		countryvo2.setStatus(false);
		countrydao1.insertCountry(countryvo2);
		List  searchList = countrydao1.searchCountry();
		return new ModelAndView("searchcountry", "searchList", searchList);
		

		
	}

	@RequestMapping(value = "edit.html", method = RequestMethod.GET)
	public ModelAndView Edit(@ModelAttribute countryVo countryVo, @RequestParam int id, HttpServletRequest request) {
		countryVo.setCountryId(id);
		List searchList = countrydao1.editCountry(countryVo);

		return new ModelAndView("country", "Data", searchList.get(0));

	}
}