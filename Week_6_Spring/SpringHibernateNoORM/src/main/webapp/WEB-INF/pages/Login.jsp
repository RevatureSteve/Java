<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Login</title>
</head>
<body>

<form:form action="login" method="POST" commandName="user">
	Username:<form:input path="bankUsername" />
	Password:<form:input path="bankPassword" />
	<input type="submit" value="Login"/>
</form:form>

</body>
</html>