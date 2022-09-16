package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import dao.regdao;
import dao.regvo;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class regcon
 */
@WebServlet("/regcon")
public class regcon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regcon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	String Searchflag = request.getParameter("flag");
	
	System.out.println("Searchflag :: "+Searchflag);
	if(Searchflag.equals("search"))
	{
		search(request,response);
		response.sendRedirect("search.jsp");
	}
	
	if(Searchflag.equals("delete"))
	{
		System.out.println("Searchflag delete :: "+Searchflag);
		delete(request,response);
		search(request,response);
		response.sendRedirect("search.jsp");
	}
	
	if(Searchflag.equals("edit"))
	{
		edit(request,response);
		response.sendRedirect("Edit.jsp");
		
	}
}

	

	private void edit(HttpServletRequest request, HttpServletResponse response) {

		 int id= Integer.parseInt(request.getParameter("uid"));
		System.out.println("id in edit"+id);
		
		regvo v3 =new regvo();
		v3.setId(id);
		
		regdao d2 = new regdao();
		 List ls1 =(List)d2.edit(v3);
		HttpSession session =request.getSession();
		session.setAttribute("ls", ls1);
		
		System.out.println("ls size :::"+ls1.size());
		
	}
		
		

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		 int id= Integer. parseInt(request. getParameter("id"))	;
		 System.out.println("Searchflag delete :: "+id);
		 
		regvo v1= new regvo();
		v1.setId(id);
		
		regdao d1 = new regdao();
		d1.delete(v1);
		
	}

	private void search(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		regdao d2 = new regdao();
		List ls = (List) d2.search();
		//System.out.println("list size:::"+ls.size());
		HttpSession session =request.getSession();
		session.setAttribute("ls",ls);	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String insertflag = request.getParameter("flag");
		
		if(insertflag.equals("insert"))
		{
		insert(request,response);
		response.sendRedirect("register.jsp");
		}
		if(insertflag.equals("update"))
		{
			 System.out.println("insertflag update :: "+insertflag);
			update(request,response);
			search(request,response);
			response.sendRedirect("search.jsp");	
		}
		}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		 int id= Integer.parseInt(request.getParameter("id"));
	System.out.println("id in uPdate ::"+id);
		String fn1 = request.getParameter("fn");
		String ln1 = request.getParameter("ln");
	
		System.out.println("fn1 ::update  "+id);
		System.out.println("fn1 ::update  "+fn1);
		System.out.println("ln1 ::update  "+ln1);
		
		regvo v1 = new regvo();
		v1.setId(id);
		v1.setFn(fn1);
		v1.setLn(ln1);
		
		regdao d3 = new regdao();
		d3.update(v1);
		
		
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String id1 =request.getParameter("id");
		String fn1 = request.getParameter("fn");
		String ln1 = request.getParameter("ln");
		
		regvo v1 = new regvo();
		v1.setFn(fn1);
		v1.setLn(ln1);
		
		regdao d1 = new regdao();
		d1.insert(v1);
		
		
	}
	
	
		
	}

