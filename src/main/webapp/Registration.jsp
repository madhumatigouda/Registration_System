<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<h2>New Registration</h2>
	<form action="register" method="post">
		Name:<input type="text" name="name" placeholder="Enter the Name"><br>
		<br>Email: <input type="email" name="email"
			placeholder="Enter the email"><br>
		<br>Date of Birth <input type="date" name="dob"
			placeholder="Enter the Date-Of-Birth"><br>
		<br> Password:<input type="password" name="password"
			placeholder="Enter your Password"><br>
		<br> <input type="submit" value="Register">
	</form>
</body>
</html>