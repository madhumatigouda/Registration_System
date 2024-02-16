<%@page import="java.util.List"%>
<%@page import="com.madhu.registration.Register"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Registration</title>
</head>
<body>


	<%
	Register reg = (Register) request.getAttribute("list");
	%>

	<h2>Update</h2>
	<form action="saveUpdatedValue" method="post">
		<input type="number" name="id" value="<%=reg.getId()%>"
			readonly="true"><br>
		<br> Name: <input type="text" name="name"
			placeholder="Enter the Name" value="<%=reg.getName()%>"><br>
		<br> Email:<input type="email" name="email"
			placeholder="Enter the email" value="<%=reg.getEmail()%>"
			readonly="true"><br>
		<br> Date Of Birth:<input type="date" name="dob"
			placeholder="Enter the Date-Of-Birth" value="<%=reg.getDob()%>"><br>
		<br> Password:<input type="password" name="password"
			placeholder="Enter your Password" value="<%=reg.getPassword()%>"><br>
		<br> <input type="submit" value="Update">


	</form>
</body>
</html>