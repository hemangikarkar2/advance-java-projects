package com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vo.regvo;
import com.dao.redao;

@Controller
public class regController {

		@Autowired
		private redao d1;
		
		public ModelAndView load(){
		
			return new ModelAndView("register","Data",new regvo());
			
		}
		@RequestMapping(value="insert.html", method=RequestMethod.POST)
		public ModelAndView insert(@ModelAttribute regvo regvo, @RequestParam int Id)
		{
			regvo.setId(Id);
			d1.insert(regvo);
			return new ModelAndView("redirect:/search/html");
		}
		@RequestMapping(value="search.html",method=RequestMethod.GET)
		public ModelAndView search(){
			List ls = d1.search();
			return  new ModelAndView("search","SearchList",ls);
			
		}
		@RequestMapping(value="delete.html",method=RequestMethod.GET)
		public ModelAndView Delete(@ModelAttribute regvo regvo, @RequestParam int Id)
		{
			regvo.setId(Id);
			d1.delete(regvo);
			
			List ls=d1.search();
			return new ModelAndView("search","SearchList",ls);
			
		}
		@RequestMapping(value="edit.html",method=RequestMethod.GET)
		public ModelAndView edit(@ModelAttribute regvo regvo,@RequestParam int Id){
			
			regvo.setId(Id);
			List ls1=d1.edit(regvo);
			return new ModelAndView("register","Data",ls1.get(0));

		}
}
