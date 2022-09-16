package com.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.RegDAO;
import com.VO.RegVO;

/**
 * Servlet implementation class RegController
 */
@WebServlet("/RegController")
public class RegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**  
     * @see HttpServlet#HttpServlet()
     */
    public RegController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String flag=request.getParameter("flag");
		if(flag.equals("search"))
		{	
			search(request,response);
			response.sendRedirect("Search.jsp");
		}

		
		if(flag.equals("delete"))
		{	
			delete(request,response);
			search(request,response);
			response.sendRedirect("Search.jsp");
		}

		
		if(flag.equals("edit"))
		{	
			edit(request,response);
			response.sendRedirect("Edit.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	
		String flag=request.getParameter("flag");
		if(flag.equals("insert"))
		{	
			insert(request,response);
			response.sendRedirect("Register.jsp");
		}
		
		
		if(flag.equals("update"))
		{	
			update(request,response);
			search(request,response);
			response.sendRedirect("Search.jsp");
		}
	
	}
	
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Fn = request.getParameter("firstName");
		String Ln = request.getParameter("lastName");
		
		RegVO regVO = new RegVO();
		regVO.setFirstName(Fn);
		regVO.setLastName(Ln);
		
		RegDAO regDAO = new RegDAO();
		regDAO.insert(regVO);

		
	}
	
protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List SearchList =new ArrayList<>();
		
		RegDAO regDAO = new RegDAO();
		SearchList =  regDAO.search();
		
		HttpSession session = request.getSession();
		session.setAttribute("SearchList", SearchList);
				
		
	}

	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int Id1 = Integer.parseInt(request.getParameter("id"));
		
		RegVO regVO = new RegVO();
		regVO.setId(Id1);
		
		RegDAO regDAO = new RegDAO();
		regDAO.delete(regVO);

		
	}
	
	
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List EditList = new ArrayList<>();
		
		int Id1 = Integer.parseInt(request.getParameter("id"));
		
		RegVO regVO = new RegVO();
		regVO.setId(Id1);
		
		RegDAO regDAO = new RegDAO();
		EditList = regDAO.edit(regVO);


		HttpSession session = request.getSession();
		session.setAttribute("EditList", EditList);
		
		
	}	

	
		protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			int Id1 = Integer.parseInt(request.getParameter("id"));
			String Fn = request.getParameter("firstName");
			String Ln = request.getParameter("lastName");
			
			RegVO regVO = new RegVO();
			regVO.setId(Id1);
			regVO.setFirstName(Fn);
			regVO.setLastName(Ln);	
			
			RegDAO regDAO = new RegDAO();
			regDAO.update(regVO);
			
		
	}

}
