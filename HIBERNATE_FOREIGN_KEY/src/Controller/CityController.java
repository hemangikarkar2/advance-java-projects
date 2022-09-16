package Controller;

import java.io.IOException;



import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CountryDAO;
import VO.CountryVO;
import DAO.StateDAO;
import VO.StateVO;
import DAO.CityDAO;
import VO.CityVO;

/**
 * Servlet implementation class CityController
 */
@WebServlet("/CityController")
public class CityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag=request.getParameter("flag");
		

		if(flag.equals("searchState"))
		{	
			searchState(request,response);
			response.sendRedirect("City.jsp");
		}
		
		if(flag.equals("searchCity"))
		{
			searchCity(request,response);
			response.sendRedirect("CitySearch.jsp");
		}		

		
		if(flag.equals("delete"))
		{
			delete(request,response);
			searchCity(request,response);
			response.sendRedirect("CitySearch.jsp");
		}
		

		if(flag.equals("edit"))
		{	
			edit(request,response);
			searchState(request,response);
			response.sendRedirect("EditCity.jsp");
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String flag=request.getParameter("flag");
		
		if(flag.equals("searchState"))
		{	
			searchState(request,response);
			response.sendRedirect("CitySearch.jsp");

		}
		

		if(flag.equals("insert"))
		{	
			insert(request,response);
			searchCity(request,response);
			response.sendRedirect("CitySearch.jsp");

		}

		
		if(flag.equals("update"))
		{	
			update(request,response);
			searchCity(request,response);
			response.sendRedirect("CitySearch.jsp");
		}

}
	

	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 int cid=Integer.parseInt(request.getParameter("country"));
		 int sid=Integer.parseInt(request.getParameter("state"));
		 
			CountryVO v1=new CountryVO();
			v1.setId(cid);
			
			StateVO v2=new StateVO();
			v2.setId(sid);
			
			String cityname=request.getParameter("city");
			CityVO v3=new CityVO();
			
			v3.setC(v1);
			v3.setSv(v2);
			v3.setCity(cityname);
			
			CityDAO cd=new CityDAO();
			cd.insert(v3);

			
	}	

	protected void searchState(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		CountryDAO d=new CountryDAO();
		List ls1 = d.search();
		
		HttpSession session1 = request.getSession();
		session1.setAttribute("list1",ls1);
		
		
		StateDAO d1=new StateDAO();
		List ls2 = d1.search();
		
		HttpSession session=request.getSession();
		session.setAttribute("list2",ls2);
		
	}	
	
	protected void searchCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		CityVO v3=new  CityVO();
		
		CityDAO cd=new CityDAO();
		List ls = cd.search();
		
		HttpSession session=request.getSession();
		session.setAttribute("list3",ls);
		
	}	
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id1 = Integer.parseInt(request.getParameter("id"));
		
		CityVO v3 = new CityVO();
		v3.setId(id1);
		
		CityDAO cd = new CityDAO();
		cd.delete(v3);
		
		List ls = cd.search();
		HttpSession session = request.getSession();
		session.setAttribute("list3", ls);
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id1 = Integer.parseInt(request.getParameter("id"));
		
		CityVO v3 = new CityVO();
		v3.setId(id1);
		
		CityDAO cd = new CityDAO();
		List ls=cd.edit(v3);
		
		HttpSession session = request.getSession();
		session.setAttribute("list3", ls);
		}

	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cid=Integer.parseInt(request.getParameter("cn"));
		int sid=Integer.parseInt(request.getParameter("sn"));
		int id1=Integer.parseInt(request.getParameter("id"));
		
		CountryVO v1=new CountryVO();
		v1.setId(cid);
		
		
		StateVO v2 = new StateVO();
		v2.setId(sid);
	
		String s1=request.getParameter("city");
		CityVO v3 = new CityVO();
		v3.setId(id1);
		v3.setCity(s1);
		v3.setC(v1);
		v3.setSv(v2);
		
		CityDAO cd = new CityDAO();
		cd.update(v3);
		
		List ls=cd.search();
		HttpSession session = request.getSession();
		session.setAttribute("list3", ls);
		
	}


}
