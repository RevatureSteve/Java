<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Home</title>
</head>
<body>
<a href="/SpringHibernateNoORM/login">Want to login again because it was sooooo funnn?</a>
<c:out value="${user.bankUsername }"></c:out>
</body>
</html>