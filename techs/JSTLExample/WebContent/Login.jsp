<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<form method="POST" action="login.do">
	
	Enter Name: <input type="text" name="name" />
	<br />
	Enter Age: <input type="number" name="age" />
	<br />
	Select Hobby: <br />
	<input type="radio" name="hobby" value="Java" /> Java
	<input type="radio" name="hobby" value="C#" /> C#
	<input type="submit" value="Login"> 
</form>
</body>
</html>