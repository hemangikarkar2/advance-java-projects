package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.countrydao;

import vo.countryvo;

/**
 * Servlet implementation class countrycontroller
 */
@WebServlet("/countrycontroller")
public class countrycontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public countrycontroller() {
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
			response.sendRedirect("countrysearch.jsp");
		}
		
		if(flag.equals("delete"))
		{
			delete(request,response);
			search(request,response);
			response.sendRedirect("countrysearch.jsp");
		}
		
		if(flag.equals("edit"))
		{	
			edit(request,response);
			response.sendRedirect("editcountry.jsp");
		}

	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String flag =request.getParameter("flag");
		if(flag.equals("insert"))
		{
			insert(request,response);
			search(request, response);
			response.sendRedirect("countrysearch.jsp");
		}
		if(flag.equals("update"))
		{	
			update(request,response);
			search(request,response);
			response.sendRedirect("countrysearch.jsp");
		}
	}
	private void insert(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String CountryName = request.getParameter("countryname");
		
		countryvo convo = new countryvo();
		//convo.setCountryName(CountryName);s
		convo.setCountryName(CountryName);
	
		countrydao cdao =new countrydao();
		cdao.insert(convo);
		
	}

	private void search(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		countrydao countrydao = new countrydao();
		List countryList = countrydao.search();
		
		HttpSession session = request.getSession();
		session.setAttribute("countryList", countryList);
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id1 = Integer.parseInt(request.getParameter("id"));
		
		countryvo v = new countryvo();
		v.setId(id1);
		
		countrydao d = new countrydao();
		d.delete(v);
		
		List ls = d.search();
		HttpSession session = request.getSession();
		session.setAttribute("CountryList", ls);
		
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		int id1 = Integer.parseInt(request.getParameter("id"));
		
		countryvo v = new countryvo();
		v.setId(id1);
		
		countrydao d = new countrydao();
		List ls=d.edit(v);
	
		HttpSession session = request.getSession();
		session.setAttribute("EditList", ls);
		System.out.println("editlist size :::"+ls.size());
	}


	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String s1=request.getParameter("countryName");
		int id1=Integer.parseInt(request.getParameter("id"));
		
		countryvo v=new  countryvo();
		v.setCountryName(s1);;
		v.setId(id1);
		
		countrydao d = new countrydao();
		d.update(v);
		
		List ls=d.search();
		HttpSession session = request.getSession();
		session.setAttribute("CountrList", ls);				

	}

}
