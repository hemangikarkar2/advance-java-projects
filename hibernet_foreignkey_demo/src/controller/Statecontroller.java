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
import dao.statedao;
import vo.countryvo;
import vo.statevo; 	

/**
 * Servlet implementation class Statecontroller
 */
@WebServlet("/Statecontroller")
public class Statecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Statecontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String flag=request.getParameter("flag");
		if(flag.equals("searchcountry"))
		{	
			searchCountry(request,response);
			response.sendRedirect("state.jsp");
		}
				
		if(flag.equals("searchState"))
		{
			searchState(request,response);
			response.sendRedirect("statesearch.jsp");
		}
		
		if(flag.equals("delete"))
		{
			delete(request,response);
			searchState(request,response);
			response.sendRedirect("statesearch.jsp");
		}
		
		if(flag.equals("edit"))
		{	
			edit(request,response);
			searchCountry(request, response);
			response.sendRedirect("editstate.jsp");
		}
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id1 = Integer.parseInt(request.getParameter("id"));
		
		statevo v2 = new statevo();
		v2.setId(id1);
		
		statedao d = new statedao();
		List ls=d.edit(v2);
		
		HttpSession session = request.getSession();
		session.setAttribute("EditList", ls);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id1 = Integer.parseInt(request.getParameter("id"));
		
		statevo v2 = new statevo();
		v2.setId(id1);
		
		statedao d = new statedao();
		d.delete(v2);
		
		List ls = d.search();
		HttpSession session = request.getSession();
		session.setAttribute("StateList", ls);
	}

	private void searchState(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		statevo v2=new  statevo();
		
		statedao d=new statedao();
		List ls = d.search();
		
		HttpSession session=request.getSession();
		session.setAttribute("StateList",ls);
		
	}

	private void searchCountry(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		countrydao d  = new countrydao();
		
		List ls = d.search();
		
		HttpSession session=request.getSession();
		session.setAttribute("CountryList",ls);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String flag=request.getParameter("flag");
		if(flag.equals("insert"))
		{	
			insert(request,response);
			searchState(request,response);
			response.sendRedirect("statesearch.jsp");

		}
		
		if(flag.equals("update"))
		{	
			update(request,response);
			searchState(request,response);
			response.sendRedirect("statesearch.jsp");
		}

	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int s1=Integer.parseInt(request.getParameter("countryname"));
		String s2=request.getParameter("statename");
		int id1=Integer.parseInt(request.getParameter("id"));
		
		countryvo v1=new countryvo();
		v1.setId(s1);
		
		statevo v2 = new statevo();
		v2.setId(id1);
		v2.setStatename(s2);
		v2.setCon(v1);

		statedao d = new statedao();
		d.update(v2);
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		 int cid=Integer.parseInt(request.getParameter("countryname"));
		 
		 countryvo v1 = new countryvo();
		 v1.setId(cid);
		 
		 	String statename=request.getParameter("statename");
			statevo v2=new statevo();
			v2.setCon(v1);		//country object pass to set country name
			v2.setStatename(statename);
			
			statedao d=new statedao();
			d.insert(v2);
			
	}

	}

