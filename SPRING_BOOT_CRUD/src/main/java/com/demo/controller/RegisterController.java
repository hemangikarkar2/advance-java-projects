package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.RegisterVO;
import com.demo.service.RegisterService;

@Controller
public class RegisterController {

	@Autowired
	RegisterService registerService;

	@GetMapping(value = "/")
	public ModelAndView Load() {
		return new ModelAndView("register", "data", new RegisterVO());
	}

	@PostMapping(value = "insert")
	public ModelAndView Insert(@ModelAttribute RegisterVO registerVO, @RequestParam int id) {

		registerVO.setStatus(true);
		this.registerService.insert(registerVO);

		return new ModelAndView("redirect:/");
	}

	@GetMapping(value = "search")
	public ModelAndView Search() {

		List searchList = this.registerService.search();

		return new ModelAndView("search", "searchList", searchList);
	}

	@GetMapping(value = "delete")
	public ModelAndView Delete(@ModelAttribute RegisterVO registerVO, @RequestParam int Id) {

		registerVO.setId(Id);
		List deleteList = this.registerService.deleteEdit(registerVO);
		RegisterVO registerVO2 = (RegisterVO) deleteList.get(0);
		registerVO2.setStatus(false);

		this.registerService.insert(registerVO2);

		return new ModelAndView("search", "searchList", registerVO2);
	}

	@GetMapping(value = "edit")
	public ModelAndView Edit(@ModelAttribute RegisterVO registerVO, @RequestParam int Id) {

		registerVO.setId(Id);
		List editList = this.registerService.deleteEdit(registerVO);
		return new ModelAndView("register", "data", editList.get(0));
	}
}
	