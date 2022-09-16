package SV_JDBC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet_update
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int i=0;
		String fn="";
		String ln="";
		
		try {
			
			
			int id1 = Integer.parseInt(request.getParameter("Id"));
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost/demodb(new)","root","root");
			Statement st=c.createStatement();
			ResultSet r=st.executeQuery("select * from jdbc_login where Id='"+id1+"'");

			while ( r.next() )
			{ 
			  
				i =r.getInt("Id");
				fn=r.getString ("Firstname");
				ln=r.getString ("Lastname");
			}
			st.close();
			c.close();

		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	

		PrintWriter p = response.getWriter();
		response.setContentType("text/html");

		p.println("<form action=UpdateServlet>");
		p.println("<table>");
		p.println("<tr><td>First_name</td><td><input type=text name=fn value="+fn+"></td></tr>");
		p.println("<tr><td>Last_name</td><td><input type=text name=ln value="+ln+"></td></tr>");
		p.println("<tr><td><input type=hidden name=id value="+i+">");
		p.println("<input type=submit value=submit></td></tr>");
		p.println("</table>");
		p.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		try {
			PrintWriter p = response.getWriter();
			response.setContentType("text/html");
			
			int id2 = Integer.parseInt(request.getParameter("id"));
			String fn2=request.getParameter("fn");
			String ln2=request.getParameter("ln");
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost/demodb(new)","root","root");
			Statement st=c.createStatement();
			st.executeUpdate("update jdbc_login set Firstname='"+fn2+"',Lastname='"+ln2+"' where Id="+id2);
			p.println("row updated successfully");
			st.close();
			c.close();
			
		} 
		catch(Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
