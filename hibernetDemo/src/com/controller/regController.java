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

import com.Dao.regDao;

import com.VO.regVo;

/**
 * Servlet implementation class regController
 */
@WebServlet("/regController")
public class regController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String flag = request.getParameter("flag");
		if(flag.equals("search"))
		{
			search(request, response);
			response.sendRedirect("search.jsp");
		}
		if(flag.equals("edit"))
		{
			edit(request, response);
			response.sendRedirect("edit.jsp");
		}
		if(flag.equals("delete"))
		{
			delete(request,response);
			search(request,response);
			response.sendRedirect("search.jsp");
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id1 = Integer.parseInt(request.getParameter("id"));
		
		regVo regVo = new regVo();
		regVo.setId(id1);
		
		regDao regDao = new regDao();
		regDao.delete(regVo);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		List EditList = new ArrayList<>();
		
		int Id1 = Integer.parseInt(request.getParameter("id"));
		
		regVo regVo = new regVo();
		regVo.setId(Id1);
		
		regDao regDao = new regDao();
		EditList = regDao.edit(regVo);


		HttpSession session = request.getSession();
		session.setAttribute("EditList", EditList);
		
		
	}

	private void search(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		List SearchList =new ArrayList<>();
		
		regDao regDao = new regDao();
		SearchList = regDao.search();
		
		HttpSession session = request.getSession();
		session.setAttribute("SearchList",SearchList);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	
		String flag = request.getParameter("flag");
		if(flag.equals("insert"))
		{
			insert(request, response);
			response.sendRedirect("register.jsp");
		}
		if(flag.equals("update"))
		{
			update(request, response);
			search(request, response);
			response.sendRedirect("search.jsp");
		}
	}



	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int Id2 = Integer.parseInt(request.getParameter("id"));
		String  fn = request.getParameter("firstName");  
		String  ln = request.getParameter("lastName");
		String  dpt = request.getParameter("department");
		String  eid= request.getParameter("empid");
		String pwd = request.getParameter("password");
		
		regVo regVo = new regVo();
		regVo.setId(Id2);
		regVo.setFn(fn);
		regVo.setLn(ln);
		regVo.setDept(dpt);
		regVo.setEmpid(eid);
		regVo.setPwd(pwd);
		
		regDao regDao = new regDao();
		regDao.update(regVo);
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
			
			String  fn = request.getParameter("firstName");
			String  ln = request.getParameter("lastName");
			String  dpt = request.getParameter("department");
			String  eid= request.getParameter("empid");
			String pwd = request.getParameter("pwd");
			
			regVo regVo = new regVo();
			regVo.setFn(fn);
			regVo.setLn(ln);
			regVo.setDept(dpt);
			regVo.setEmpid(eid);
			regVo.setPwd(pwd);
			
			regDao regDao = new regDao();
			regDao.insert(regVo);
	}

}
