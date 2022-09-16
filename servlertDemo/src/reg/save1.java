package reg;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class save1
 */
@WebServlet("/save1")
public class save1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public save1() {
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
		String firstname = request.getParameter("fn");
		String lastname = request.getParameter("ln");
		String username = request.getParameter("un");
		String password = request.getParameter("pwd");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/reg_servlet_demo","root","root");
				Statement s= c.createStatement();
				int result=s.executeUpdate("Insert into regservlet(firstname,lastname,username,password) values ('"+firstname+"','"+lastname+"','"+username+"','"+password+"')");
				response.sendRedirect("reg/login.jsp");
				
				HttpSession s1 = request.getSession();
				s1.setAttribute("username", username);
				s1.setAttribute("password", password);
				c.close();
				s.close();	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
