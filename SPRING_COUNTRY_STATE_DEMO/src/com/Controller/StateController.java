package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DAO.CountryDAO;
import com.DAO.StateDAO;
import com.VO.StateVO;

@Controller
public class StateController {

	@Autowired CountryDAO countryDAO;
	@Autowired StateDAO stateDAO;
	
	@RequestMapping(value="loadState.html",method=RequestMethod.GET)
	public ModelAndView LoadState()
	{
		List countryList = countryDAO.searchCountry();
		return new ModelAndView("State","data",new StateVO()).addObject("countryList",countryList);
	}
	
	@RequestMapping(value="insertState.html",method=RequestMethod.POST)
	public ModelAndView SearchState(@ModelAttribute StateVO stateVO,@RequestParam int stateId)
	{
		stateVO.setStateId(stateId);
		stateVO.setStatus(true);
		stateDAO.insertState(stateVO);
		return new ModelAndView("redirect:/loadState.html");
	}
	
	@RequestMapping(value="searchState.html",method=RequestMethod.GET)
	public ModelAndView InsertState(@ModelAttribute StateVO stateVO)
	{
		
		List stateList = stateDAO.searchState();
	
		return new ModelAndView("StateSearch","stateList",stateList);
	}
	
	
	@RequestMapping(value="deleteState.html",method=RequestMethod.GET)
	public ModelAndView DeleteState(@ModelAttribute StateVO stateVO,@RequestParam int sid)
	{
		
		stateVO.setStateId(sid);
		stateVO.setStatus(false);
		
		stateDAO.deleteState(stateVO);
		
		List stateList = stateDAO.searchState();
		return new ModelAndView("StateSearch","stateList",stateList);
	}

	@RequestMapping(value="editState.html",method=RequestMethod.GET)
	public ModelAndView editState(@ModelAttribute StateVO stateVO,@RequestParam int sid)
	{
		
		stateVO.setStateId(sid);
		
		List countryList = countryDAO.searchCountry();
		List editList=stateDAO.editState(stateVO);
		

		return new ModelAndView("State","data",editList.get(0)).addObject("countryList", countryList);
	}

}
