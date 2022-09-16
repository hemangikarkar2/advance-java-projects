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

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
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
		String id = request.getParameter("id");
		System.out.println("idddddd;;;;;"+id);
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3307/reg_servlet_demo","root","root");
			Statement s = c.createStatement();
			ResultSet rs=null;
			String sql= "select * from regservlet where id='"+id+"'";
			rs=s.executeQuery(sql);
				
			String firstname1 =request.getParameter("firstname");
			String lastname1= request.getParameter("lastname");
			String username1=request.getParameter("username");
			String password1 = request.getParameter("password");
			
			
			/*System.out.println("firstname ::" +firstname1);
			System.out.println("lasstname ::" +lastname1);
			System.out.println("usertname ::" +username1);
			System.out.println("passweod ::" +password1); */
			if(firstname1 != null && lastname1 != null && username1 != null && password1 != null )
			{
				int i =s.executeUpdate("update regservlet set firstname='"+firstname1+"',lastname='"+lastname1+"',username='"+username1+"',password='"+password1+"' where id ='"+id+"'");
				if(i>0)
				{
					response.sendRedirect("search");	
				}
				
			}
			else{
					out.println("there will be problem while updating");
					response.sendRedirect("edit");
				}
		
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
