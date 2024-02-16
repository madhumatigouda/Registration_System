<%@page import="com.madhu.registration.Register"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Registration</title>
</head>
<body>
	<%
	List<Register> list = (List) request.getAttribute("details");
	%>

	<table border="">
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Date-of-Birth</th>
			<th>Password</th>
			<th>Update Mobile</th>
			<th>Delete Mobile</th>
		</tr>

		<%
		for (Register reg : list) {
		%>

		<tr>
			<th><%=reg.getName()%></th>
			<th><%=reg.getEmail()%></th>
			<th><%=reg.getDob()%></th>
			<th><%=reg.getPassword()%></th>
			<td><a href="update?id=<%=reg.getId()%>">Update</a></td>
			<td><a href="delete?email=<%=reg.getEmail()%>">Delete</a></td>

		</tr>

		<%
		}
		%>
	</table>
<br><br>
	<a href="index.jsp">DashBoard</a>
</body>
</html>