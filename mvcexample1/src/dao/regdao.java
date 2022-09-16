package dao;

import java.io.PrintWriter;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class regdao {

		
		private static final PrintWriter Response = null;
			
		
		public void insert(regvo v1 ){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/demodb","root","root");
				Statement s = c.createStatement();
				s.executeUpdate("insert into mvcdb(firstname,lastname) values('"+v1.getFn()+"','"+v1.getLn()+"')");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		public List search()
		{
			List ls = new ArrayList<>();
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/demodb","root","root");
				Statement s = c.createStatement();
				ResultSet rs= s.executeQuery("select * from mvcdb");
				
				while(rs.next())
				{
				 regvo v1 = new regvo();
				 int id2=rs.getInt("id");
				 String fn2=rs.getString("firstname");
				 String ln2=rs.getString("lastname");
				 v1.setId(id2);
				 v1.setFn(fn2);
				 v1.setLn(ln2);
				 ls.add(v1);
				}
				//return ls;
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ls;
				}
		
		public void delete(regvo v1){
			try {
				System.out.println("Searchflag delete 123 :: "+v1.getId());
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/demodb","root","root");
				Statement s = c.createStatement();
				s.executeUpdate("delete from mvcdb where id='"+v1.getId()+"'");
					}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();}
		}
				
		public List edit(regvo v5){
			List ls1 = new ArrayList<>();
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/demodb","root","root");
				Statement s = c.createStatement();
				ResultSet rs =s.executeQuery("select * from mvcdb where id='"+v5.getId()+"'");
				while(rs.next())
				{
					int id =rs.getInt("id");
					String fn = rs.getString("firstname");
					String ln=rs.getString("lastname");
					v5.setId(id);
					v5.setFn(fn);
					v5.setLn(ln);
					ls1.add(v5);
				}
				}
		
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}
			return ls1;
		}
		
		public void update(regvo v1)
		{
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/demodb","root","root");
				Statement s = c.createStatement();
				s.executeUpdate("update mvcdb set firstname='"+v1.getFn()+"',lastname='"+v1.getLn()+"' where id ='"+v1.getId()+"'"); 
				
				}
		
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}
		}
}


