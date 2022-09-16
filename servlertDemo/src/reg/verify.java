package reg;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class verify
 */
@WebServlet(name = "verify1", urlPatterns = { "/verify1" })
public class verify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		//String id = request.getParameter("id");
		//System.out.println("iddd : "+id);
		HttpSession s1 = request.getSession();
		String username1 =(String)s1.getAttribute("username");
		String username = request.getParameter("un");
		String password1=(String)s1.getAttribute("password");
		String password = request.getParameter("pwd");
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3307/reg_servlet_demo","root","root");
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("select * from regservlet where username='"+username+"' and password='"+password+"'");
			
			if(rs.next())
			{
			
				if(username.equals(username1) && password.equals(password1))
				{
					response.sendRedirect("reg/welcome.jsp");
				}
				else
				{
					response.sendRedirect("reg/login.jsp");
				}
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		}
	

}
