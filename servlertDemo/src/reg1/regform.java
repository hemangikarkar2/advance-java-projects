package reg1;

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
 * Servlet implementation class regform
 */
@WebServlet("/regform")
public class regform extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public regform() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String loginflag = request.getParameter("flag");
		System.out.println("flag : " + loginflag);
		// login

		// System.out.println("login flag ::"+loginflag);

		if (loginflag.equals("login")) {
			try {

				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/reg_servlet_demo", "root",
						"root");
				Statement s = c.createStatement();
				// String firstname = request.getParameter("fn");
				// String lastname = request.getParameter("ln");
				String username = request.getParameter("un");
				String password = request.getParameter("pwd");
				// System.out.println("firstname "+firstname );
				// System.out.println("lastname "+lastname );
				System.out.println("username " + username);
				System.out.println("passe " + password);

				ResultSet rs = s.executeQuery(
						"select * from reg1 where username='" + username + "' and password='" + password + "'");

				if (rs.next()) {
					String username1 = rs.getString("username");
					String password1 = rs.getString("password");

					if (username1.equals(username) && password1.equals(password)) {
						response.sendRedirect("reg1/welcome.jsp");
					} else {
						response.sendRedirect("reg1/login.jsp");
					}

					s.close();
					c.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// search

		if (loginflag.equals("search")) {
			try {
				System.out.println("search::");
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/reg_servlet_demo", "root",
						"root");
				Statement s = c.createStatement();

				ResultSet rs1 = s.executeQuery("select * from reg1");

				out.println(
						"<table border=1 ><tr><td>id</td><td>firstname</td><td>lastname</td><td>username</td><td>action</td></tr>");
				while (rs1.next()) {

					int id = rs1.getInt("id");

					out.println("<tr><td>" + id + "</td><td>" + rs1.getString("firstname") + "</td><td>"
							+ rs1.getString("lastname") + "</td><td>" + rs1.getString("username")
							+ "</td><td><a href=regform?did=" + id
							+ "&flag=delete>delete</a>&nbsp;&nbsp;&nbsp;<a href=regform?udid=" + id
							+ "&flag=edit>edit</a></td></tr>");
					// "</td><td><a href='delete'>delete</a></td></tr>");
					// out.println("delete id ::: "+did);
					// <a href=edit?udid="+id+"

				}

				out.println("</table>");
				s.close();
				c.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		// delete

		if (loginflag.equals("delete")) {
			String id2 = request.getParameter("did");
			System.out.println("idd  for delete ::: " + id2);

			try {
				System.out.println("delete::");
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/reg_servlet_demo", "root",
						"root");
				Statement s = c.createStatement();
				s.executeUpdate("delete from reg1 where id='" + id2 + "'");

				if (id2 != null) { // String id = request.getParameter("did");
					// System.out.println("idd ::: "+id1);
					if (id2 != null) {

						s.executeUpdate("delete from reg1 where id='" + id2 + "'");
						response.sendRedirect("reg1/regform.jsp");}

					else {
						out.println("there  is problem in delete");
					}

					response.sendRedirect("reg1/regform");
				//	c.close();
					//s.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		//edit
			
		  if(loginflag.equals("edit"))
		  {
			  try
		  	{
				  System.out.println("edit::");
		  Class.forName("com.mysql.jdbc.Driver"); 
		  Connection c =DriverManager.getConnection("jdbc:mysql://localhost:3307/reg_servlet_demo", "root", "root");
		 Statement s = c.createStatement(); 
		 String uid = request.getParameter("udid"); 
		 System.out.println(uid);
		  
		  Statement s1= c.createStatement(); 
		  if(uid!=null) { 
			  String sql="select * from reg1 where id ='"+uid+"'"; 
			  ResultSet rs2 =
		 s1.executeQuery(sql); while(rs2.next()) {
		  out.println("<html><body><form action='regform' method='post'>" +
		  "<input type='hidden' name='id' value="+rs2.getInt("id")+">" +
		  "<br/>Firstname<input type='text' name='firstname' value="+rs2.
		  getString("firstname")+">" +
		  "<br/>Lastname<input type='text' name='lastname' value="+rs2.
		  getString("lastname")+">" +
		  "<br/>Username<input type='text' name='username' value="+rs2.
		  getString("username")+">" +
		  "<br/>Password<input type='password' name='password' value="+rs2.
		  getString("password")+">" +
		  "<br/><input type='hidden' name='flag' value='update'><input type='submit' value='update'/></form></body></html>");
		  //<a href='update?flag=update'>update</a>
		 }
		  
		  } 
		  c.close(); s.close(); 
		  } 
		  
		  catch(Exception e) { e.printStackTrace();}
		 
		  }
			
		

	
 } 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		/*
		 * out.
		 * println("<html><body><form><table><tr><td>firstname<input type='text' name='fn'></td></tr>"
		 * +"<tr><td>lastnam<input type='text' name='ln'></td></tr>"
		 * +"<tr><td>usernam<input type='text' name='un'></td></tr>"
		 * +"<tr><td>password<input type='password' name='pwd'></td></tr>" +
		 * "</table></body></html>");
		 */
		String insertflag = request.getParameter("flag");

		if (insertflag.equals("insert")) {

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/reg_servlet_demo", "root",
						"root");
				Statement s = c.createStatement();

				String firstname = request.getParameter("fn");
				String lastname = request.getParameter("ln");
				String username = request.getParameter("un");
				String password = request.getParameter("pwd");

				if (firstname != null && lastname != null && username != null && password != null) {
					int result = s.executeUpdate("Insert into reg1(firstname,lastname,username,password) values ('"
							+ firstname + "','" + lastname + "','" + username + "','" + password + "')");
				}
				response.sendRedirect("reg1/login.jsp");
			c.close();
				s.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
		}
		
		
		// update
		
					if(insertflag.equals("update"))
					 {
					  try
						{
						  System.out.println("update::");
					  String id3 = request.getParameter("id");
					  System.out.println("id3 update"+id3);
					  
					  Class.forName("com.mysql.jdbc.Driver"); 
					  Connection c =DriverManager.getConnection("jdbc:mysql://localhost:3307/reg_servlet_demo", "root", "root");
					 Statement s = c.createStatement(); 
					  Statement s2= c.createStatement();
					  ResultSet rs3=null; 
					  String sql= "select * from reg1 where id='"+id3+"'";
					  rs3=s2.executeQuery(sql);
					  
					  String firstname1 =request.getParameter("firstname"); 
					  String lastname1=request.getParameter("lastname"); 
					  String username1=request.getParameter("username"); 
					  String password1 =request.getParameter("password");
					  
					  if(firstname1 != null && lastname1 != null && username1 != null &&
					  password1 != null )
					  { 
						  
						  int i =s.executeUpdate("update reg1 set firstname='"+firstname1+"',lastname='"+lastname1+"',username='"+username1+"',password='"+
					  password1+"' where id ='"+id3+"'"); 
					  
						  if(i>0) {
						  response.sendRedirect("reg1/login.jsp"); 
					  	}
					  
					  }
					  else{ out.println("there will be problem while updating");
					  response.sendRedirect("reg1/regform.jsp"); }
					  c.close();	
					  s.close();
					  	
						}catch (Exception e) {
							e.printStackTrace();}
					 }
	}

}
