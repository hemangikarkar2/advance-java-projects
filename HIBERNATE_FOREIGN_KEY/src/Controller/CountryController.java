package Controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import DAO.CountryDAO;
import VO.CountryVO;



/**
 * Servlet implementation class CountryController
 */
@WebServlet("/CountryController")
public class CountryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String flag = request.getParameter("flag");
		
		if(flag.equals("search"))
		{
			search(request,response);
			response.sendRedirect("CountrySearch.jsp");
		}
		
		if(flag.equals("delete"))
		{
			delete(request,response);
			search(request,response);
			response.sendRedirect("CountrySearch.jsp");
		}
		
		if(flag.equals("edit"))
		{	
			edit(request,response);
			response.sendRedirect("EditCountry.jsp");
		}

	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag=request.getParameter("flag");
		if(flag.equals("insert"))
		{	
			insert(request,response);
			search(request, response);
			response.sendRedirect("CountrySearch.jsp");

		}
		
		if(flag.equals("update"))
		{	
			update(request,response);
			search(request,response);
			response.sendRedirect("CountrySearch.jsp");
		}

	}
	
	

	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		String countryname=request.getParameter("cn");
		
		CountryVO v1=new CountryVO();
		v1.setCn(countryname);
		
		CountryDAO d=new CountryDAO();
		d.insert(v1);
		
	}


	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		CountryVO v = new CountryVO();
		
		CountryDAO d = new CountryDAO();
		List ls = d.search();
		
		HttpSession session = request.getSession();
		session.setAttribute("CountryList", ls);
	}

	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id1 = Integer.parseInt(request.getParameter("id"));
		
		CountryVO v = new CountryVO();
		v.setId(id1);
		
		CountryDAO d = new CountryDAO();
		d.delete(v);
		
		List ls = d.search();
		HttpSession session = request.getSession();
		session.setAttribute("CountryList", ls);
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id1 = Integer.parseInt(request.getParameter("id"));
	
		CountryVO v = new CountryVO();
		v.setId(id1);
		
		CountryDAO d = new CountryDAO();
		List ls=d.edit(v);
	
		HttpSession session = request.getSession();
		session.setAttribute("EditList", ls);
		System.out.println("editlist size :::"+ls.size());
	}

	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String s1=request.getParameter("cn");
		int id1=Integer.parseInt(request.getParameter("id"));
		
		CountryVO v=new  CountryVO();
		v.setCn(s1);
		v.setId(id1);
		
		CountryDAO d = new CountryDAO();
		d.update(v);
		
		List ls=d.search();
		HttpSession session = request.getSession();
		session.setAttribute("CountrList", ls);				

}
	
}
