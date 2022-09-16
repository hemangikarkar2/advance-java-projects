package com.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DAO.CountryDAO;
import com.DAO.StateDAO;
import com.VO.CountryVO;
import com.VO.StateVO;

@Controller
public class CountryController {

	@Autowired CountryDAO countryDAO;
	
	@Autowired StateDAO stateDAO;
	
	@RequestMapping(value="load.html",method=RequestMethod.GET)
	public ModelAndView Load()
	{
		return new ModelAndView("Country","data",new CountryVO());
	}

	
	@RequestMapping(value="insert.html",method=RequestMethod.POST)
	public ModelAndView Insert(@ModelAttribute CountryVO countryVO,@RequestParam int countryId)
	{
		countryVO.setCountryId(countryId);
		countryVO.setStatus(true);
		countryDAO.insertCountry(countryVO);
		return new ModelAn	dView("redirect:/search.html");
	}
	
	
	@RequestMapping(value="search1.html",method=RequestMethod.GET)
	public ModelAndView Search(HttpServletRequest request)
	{
		List searchList = countryDAO.searchCountry();
		
		return new ModelAndView("SearchCountry","searchList",searchList);
	}
	
	
	@RequestMapping(value="delete.html",method=RequestMethod.GET)
	public ModelAndView Delete(@ModelAttribute CountryVO countryVO,StateVO stateVO,@RequestParam int id,HttpServletRequest request)
	{
		
		countryVO.setCountryId(id);
		countryVO.setStatus(false);
		List StateList=countryDAO.SearchAllState(countryVO);
		
		for(int i=0;i<StateList.size();i++)
		{
			
			stateVO = (StateVO) StateList.get(i);
			stateDAO.deleteState(stateVO);
		}
		
		countryDAO.deleteCountry(countryVO);
		
		List searchList = countryDAO.searchCountry();
		
		return new ModelAndView("SearchCountry","searchList",searchList);
	}
	
	
	@RequestMapping(value="edit.html",method=RequestMethod.GET)
	public ModelAndView Edit(@ModelAttribute CountryVO countryVO,@RequestParam int id,HttpServletRequest request)
	{
		
		countryVO.setCountryId(id);
		List searchList = countryDAO.editCountry(countryVO);
		
		return new ModelAndView("Country","data",searchList.get(0));
		
	}
}
