package Controller;

import java.io.IOException;


import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CountryDAO;
import DAO.StateDAO;
import VO.StateVO;
import VO.CountryVO;

/**
 * Servlet implementation class StateController
 */
@WebServlet("/StateController")
public class StateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		if(flag.equals("searchCountry"))
		{	
			searchCountry(request,response);
			response.sendRedirect("State.jsp");
		}
				
		if(flag.equals("searchState"))
		{
			searchState(request,response);
			response.sendRedirect("StateSearch.jsp");
		}
		
		if(flag.equals("delete"))
		{
			delete(request,response);
			searchState(request,response);
			response.sendRedirect("StateSearch.jsp");
		}
		
		if(flag.equals("edit"))
		{	
			edit(request,response);
			searchCountry(request, response);
			response.sendRedirect("EditState.jsp");
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
			searchState(request,response);
			response.sendRedirect("StateSearch.jsp");

		}
		
		if(flag.equals("update"))
		{	
			update(request,response);
			searchState(request,response);
			response.sendRedirect("StateSearch.jsp");
		}

	}

	
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 int cid=Integer.parseInt(request.getParameter("country"));
			
			CountryVO v1=new CountryVO();
			v1.setId(cid);
			
			String statename=request.getParameter("sn");
			StateVO v2=new StateVO();
			v2.setC(v1);
			v2.setSn(statename);
			
			StateDAO d=new StateDAO();
			d.insert(v2);
			
	}	
	
	
	protected void searchCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		CountryDAO d=new CountryDAO();
		List ls = d.search();
		
		HttpSession session=request.getSession();
		session.setAttribute("CountryList",ls);
		
	}	
	
	protected void searchState(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		StateVO v2=new  StateVO();
		
		StateDAO d=new StateDAO();
		List ls = d.search();
		
		HttpSession session=request.getSession();
		session.setAttribute("StateList",ls);
		
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id1 = Integer.parseInt(request.getParameter("id"));
		
		StateVO v2 = new StateVO();
		v2.setId(id1);
		
		StateDAO d = new StateDAO();
		d.delete(v2);
		
		List ls = d.search();
		HttpSession session = request.getSession();
		session.setAttribute("StateList", ls);
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id1 = Integer.parseInt(request.getParameter("id"));
	
		StateVO v2 = new StateVO();
		v2.setId(id1);
		
		StateDAO d = new StateDAO();
		List ls=d.edit(v2);
		
		HttpSession session = request.getSession();
		session.setAttribute("EditList", ls);
	}

	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int s1=Integer.parseInt(request.getParameter("cn"));
		String s2=request.getParameter("sn");
		int id1=Integer.parseInt(request.getParameter("id"));
		
		CountryVO v1=new CountryVO();
		v1.setId(s1);
		
		StateVO v2 = new StateVO();
		v2.setId(id1);
		v2.setSn(s2);
		v2.setC(v1);

		StateDAO d = new StateDAO();
		d.update(v2);
				

}

}


