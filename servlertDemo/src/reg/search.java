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
 * Servlet implementation class search
 */
@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
        super();
     
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3307/reg_servlet_demo","root","root");
			Statement s1 = c.createStatement();
			ResultSet rs = s1.executeQuery("select * from regservlet");
			//String id = request.getParameter("id");
			//System.out.println("id :::" +id);
			
			out.println("<table border=1 > <tr><td>id</td><td>firstname</td><td>lastname</td><td>username</td><td>action</td></tr>" );
			while(rs.next())
			{
			int id=rs.getInt("id");
				
				out.println("<tr><td>"+id+
							"</td><td>"+rs.getString("firstname")+
							"</td><td>"+rs.getString("lastname")+
							"</td><td>"+rs.getString("username")+
							"</td><td><a href=delete?did="+id+">delete</a>&nbsp;&nbsp;&nbsp;<a href=edit?udid="+id+">edit</a></td></tr>");
				//"</td><td><a href='delete'>delete</a></td></tr>");
				//out.println("delete id ::: "+did);
				//<a href=edit?udid="+id+"
				
			}
			
			out.println("</table></body></html>");
			c.close();
			s1.close();
			//out.println("<form ><table border=2 ><tr  height=50px><th></th><td>id</td><td>FirstName</td><td>LastName</td><td>UserName</td></tr></table></form></body></html>");

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
