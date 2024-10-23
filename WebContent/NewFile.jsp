<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, java.sql.Connection, java.sql.DriverManager, java.sql.PreparedStatement, java.sql.ResultSet, java.sql.SQLException, java.util.Map.Entry"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! String status = "Not Promoted"; %>
<%
String name = request.getParameter("firstName");
String dept = request.getParameter("dept");
String salary = request.getParameter("salary");
String year = request.getParameter("doj");

Class.forName("oracle.jdbc.driver.OracleDriver");
Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "10Aero50!");
String sql = "Select * from Employees";
PreparedStatement prepareStatement = connection.prepareStatement(sql);
ResultSet executeQuery = prepareStatement.executeQuery();
Map<String, Integer> m = new LinkedHashMap();
while(executeQuery.next()) {
	String firstname = executeQuery.getString("first_name");
	int empsalary = executeQuery.getInt("salary");
	m.put(firstname, empsalary);
}

Set<Entry<String, Integer>> entrySet = m.entrySet();
for(Entry<String, Integer> e1:entrySet){
	if(e1.getKey().equals(name)){
		out.println(e1);
	}
}


%>
</body>
</html>