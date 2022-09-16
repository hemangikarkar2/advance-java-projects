package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.regdao;
import com.vo.regvo;

/**
 * Servlet implementation class regcontroller
 */
@WebServlet("/regcontroller")
public class regcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regcontroller() {
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
		if(flag.equals("search"))
		{	
			search(request,response);
			response.sendRedirect("search.jsp");
		}

		
		if(flag.equals("delete"))
		{	
			delete(request,response);
			search(request,response);
			response.sendRedirect("search.jsp");
		}

		
		if(flag.equals("edit"))
		{	
			edit(request,response);
			response.sendRedirect("edit.jsp");
		}

	}

	private void edit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List EditList = new ArrayList<>();
		
		int Id1 = Integer.parseInt(request.getParameter("id"));
		
		regvo regvo  = new regvo();
		regvo.setId(Id1);
		
		regdao regdao = new regdao();
		EditList = regdao.edit(regvo);


		HttpSession session = request.getSession();
		session.setAttribute("EditList", EditList);
		
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int Id1 = Integer.parseInt(request.getParameter("id"));
		
		regvo  regvo = new regvo();
		regvo.setId(Id1);
		
		regdao regdao= new regdao();
		regdao.delete(regvo);

	}

	private void search(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List SearchList =new ArrayList<>();
		
		regdao regdao = new regdao();
		SearchList =  regdao.search();
		
		HttpSession session = request.getSession();
		session.setAttribute("SearchList", SearchList);
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
			response.sendRedirect("register.jsp");
		}
		
		
		if(flag.equals("update"))
		{	
			update(request,response);
			search(request,response);
			response.sendRedirect("search.jsp");
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int Id1 = Integer.parseInt(request.getParameter("id"));
		String Fn = request.getParameter("firstName");
		String Ln = request.getParameter("lastName");
		
		regvo regvo= new regvo();
		regvo.setId(Id1);
		regvo.setFirstName(Fn);
		regvo.setLastName(Ln);
		
		regdao regdao= new regdao();
		regdao.update(regvo);
		
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String Fn = request.getParameter("firstName");
		String Ln = request.getParameter("lastName");
		
		regvo regvo = new regvo();
		regvo.setFirstName(Fn);
		regvo.setLastName(Ln);
		
		regdao regdao= new regdao();
		regdao.insert(regvo);
		
	}

}
