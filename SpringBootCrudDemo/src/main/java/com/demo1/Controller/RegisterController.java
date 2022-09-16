package com.demo1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo1.Model.RegisteVO;
import com.demo1.Service.RegisterService;

@Controller
public class RegisterController {

	@Autowired
	private RegisterService registerService;

	@GetMapping(value = "/")
	public ModelAndView Load() {
		return new ModelAndView("Register", "Data", new RegisteVO());
	}

	@PostMapping(value = "insert")
	public ModelAndView Insert(@ModelAttribute RegisteVO registerVo, @RequestParam int id) {
		registerVo.setStatus(true);
		this.registerService.insert(registerVo);

		return new ModelAndView("redirect:/");
	}

	@GetMapping(value = "search")
	public ModelAndView Search() {
		List searchList = this.registerService.search();
		return new ModelAndView("Search", "searchList", searchList);
		
	}

	@GetMapping(value = "delete")
	public ModelAndView Delete(@ModelAttribute RegisteVO registerVo, @RequestParam int Id) {

		registerVo.setId(Id);
		List deleteList = this.registerService.deleteEdit(registerVo);
		RegisteVO registerVo2 = (RegisteVO) deleteList.get(0);
		registerVo2.setStatus(false);

		this.registerService.insert(registerVo2);
		return new ModelAndView("Search", "searchList", registerVo2);

	}

	@GetMapping(value = "edit")
	public ModelAndView Edit(@ModelAttribute RegisteVO registerVo, @RequestParam int Id) {
		registerVo.setId(Id);
		List editList = this.registerService.deleteEdit(registerVo);
		return new ModelAndView("Register", "Data", editList.get(0));
	}
}
