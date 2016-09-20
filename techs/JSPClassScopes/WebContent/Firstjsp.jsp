<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.revature.beans.UserBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>First</title>
</head>
<body>
<%
	//Application Scope set
	UserBean servletContextType = new UserBean();
	servletContextType.setScopeType("This is our Application Scope");
	application.setAttribute("servletContextType",servletContextType);
	
	//Session Scope
	UserBean sessionType = new UserBean();
	sessionType.setScopeType("This is our  Session Scope");
	session.setAttribute("sessionType",sessionType);
	
	//Request
	UserBean requestType = new UserBean();
	requestType.setScopeType("This is our Request Scope");
	request.setAttribute("requestType",requestType);
	
	//Page
	UserBean pageType = new UserBean();
	pageType.setScopeType("This is our Page Scope");
	pageContext.setAttribute("pageType", pageType);
	
	request.getRequestDispatcher("SecondJsp.jsp").forward(request, response);
 %>
 
 application
 <%=servletContextType.getScopeType() %>
 <br /> <br />
 Session
 <%=sessionType.getScopeType() %>
 <br/> <br />
 
 Request
 <%=requestType.getScopeType() %>
 <br /><br />
 
 Page
 <%=pageType.getScopeType() %>
 <br /><br />
 
</body>
</html>