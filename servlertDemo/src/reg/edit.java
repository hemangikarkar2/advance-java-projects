package reg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class edit
 */
@WebServlet("/edit")
public class edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String uid = request.getParameter("udid");
		System.out.println(uid);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/reg_servlet_demo","root","root");
			Statement s = c.createStatement();
			String sql="select * from regservlet where id ='"+uid+"'";
			ResultSet rs = s.executeQuery(sql);
			while(rs.next())
			{
				out.println("<html><body><form action='update' method='post'>"
						+ "<input type='hidden' name='id' value="+rs.getInt("id")+">"
						+ "<br/>Firstname<input type='text' name='firstname' value="+rs.getString("firstname")+">"
						+ "<br/>Lastname<input type='text' name='lastname' value="+rs.getString("lastname")+">"
						+ "<br/>Username<input type='text' name='username' value="+rs.getString("username")+">"
						+ "<br/>Password<input type='password' name='password' value="+rs.getString("password")+">"
						+ "<br/><input type='submit' value='Update'/></form></body></html>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
