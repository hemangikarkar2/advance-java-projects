package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.Vo.stateVo;
import com.dao.countryDao;
import com.dao.stateDao;

@Controller
public class stateController {
	@Autowired 
	private countryDao countryDao;
	@Autowired
	private stateDao stateDao;
	
	@RequestMapping(value="loadstate.html",method=RequestMethod.GET)
	public ModelAndView LoadState(){
		List countryList = countryDao.searchCountry();
		return new ModelAndView("state","Data",new stateVo()).addObject("countryList",countryList);
	}
	
	@RequestMapping(value="insertstate.html",method=RequestMethod.POST)
	public ModelAndView SearchState(@ModelAttribute stateVo stateVo,@RequestParam int stateId){
		stateVo.setStateId(stateId);
		stateVo.setStatus(true);
		stateDao.insertState(stateVo);
		return new ModelAndView("redirect:/loadstate.html");
	
	}
	
	@RequestMapping(value="searchstate.html",method=RequestMethod.GET)
	public ModelAndView InsertState(@ModelAttribute stateVo stateVo)
	{
		List stateList = stateDao.searchstate();
		return new ModelAndView("searchstate","stateList",stateList);
		
	}
	@RequestMapping(value="deletestate.html",method=RequestMethod.GET)
	public ModelAndView DeleteState(@ModelAttribute stateVo stateVo,@RequestParam int sid)
	{
		stateVo.setStateId(sid);
		stateVo.setStatus(false);
		stateDao.deleteState(stateVo);
		List stateList=stateDao.searchstate() ;
		return new ModelAndView("searchstate","stateList",stateList);
		
	}
	@RequestMapping(value="editstate.html",method=RequestMethod.GET)
	public ModelAndView editState(@ModelAttribute stateVo stateVo,@RequestParam int sid)
	{
		stateVo.setStateId(sid);
		List countryList=countryDao.searchCountry();
		List editList=stateDao.editstate(stateVo);
		return new ModelAndView("state","Data",editList.get(0)).addObject("countryList", countryList);
	
	}
	}
