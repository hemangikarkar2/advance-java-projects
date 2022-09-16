<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>delete</title>
</head>
<body>
<%
String[] select=request.getParameterValues("CheckSelect");
Class.forName("com.mysql.jdbc.Driver");
Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/demodb","root","root");
Statement s  = c.createStatement();
for(int i=0;i<select.length;i++){
	s.executeUpdate("delete  from emp_reg where  id='"+select[i]+"';");
}


response.sendRedirect("search.jsp");
c.close();
s.close();

%>
</body>
</html>






/*
<%
/*
Class.forName("com.mysql.jdbc.Driver");
Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3307/demodb","root","root");
Statement s  = c.createStatement();
ResultSet resultset = null;
String idd2="";
String[] idd1=request.getParameterValues("id");

for(int i=0;i<idd1.length;i++){
	
	//System.out.println("idd1 is(in for loop) ::"+idd1[i]); //idd1 :: i got one value
	//System.out.println("idd2 is(infor loop) ::"+idd2);   //nothing 
	idd2+=idd1[i]+","; 
}
//System.out.println("idd1 is(out of for loop) ::"+idd1); // error  :[Ljava.lang.String;@372edcb7
//String id3 = request.getParameter("idd2");
     System.out.println("idd2 is(out of for loop) ::"+idd2);// i got multiple id's : 9,11
     
     //String[] id4;
 for(int i=0;i<idd2.length();i++)
 {
	System.out.println("idv3 length :"+idd2.length());
		 //id4 = idd2.split(",");
		//System.out.println("id4 length :"+id4);
		
		
		 // s.executeUpdate("delete * from emp_reg where  id='"+id+"'");
	
 }
 for(int i=0;i<idd2.length();i++)
 {
	System.out.println("idv3 length :"+idd2.length());
		String[] id4 = idd2.split(",");
		System.out.println("id4 length :"+id4);
		
		
		 // s.executeUpdate("delete * from emp_reg where  id='"+id+"'");
	
 }

//String id1="";
//String[] id2 = request.getParameterValues("id");
//String id= request.getParameter("id");
// i got 1 id ::-System.out.println("id is :"+id);
//for(int a=0;a<=id2.length;a++)
//{
//	id1+=id2[a];
	// i didnt get anything System.out.println("id is :"+id2);
	// i got length of id System.out.println("id length is :"+id2.length);
	// i got first id : System.out.println("id2[a] is :"+id2[a]);
	
//}
//s.executeUpdate("delete * from emp_reg where  id='"+id+"'");
//System.out.println("id1 is::::; :"+id1);
response.sendRedirect("search.jsp");
c.close();
s.close();
*/
%>
</body>
</html> -->
