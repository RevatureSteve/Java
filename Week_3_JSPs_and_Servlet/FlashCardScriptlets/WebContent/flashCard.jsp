<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.flashcard.domain.FlashCard" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flash Card</title>
<link type="text/css" rel="stylesheet" href="bootstrap-3.3.6-dist/css/bootstrap.css" />
</head>
<body>
  
<!--   Runs once, when the page goes through page translation -->
  <%! FlashCard currentFlashCard = null; %>
  
<!--   
	Runs every time page is loaded (per request).
	It's put inside the _jspService() method
 -->
  <% currentFlashCard = (FlashCard) request.getAttribute("currentFlashCard"); %>
  
  <div class="container">
    <div class="jumbotron">
      <h2 class="text-center">Flash Card App</h2>
    </div>
  </div>
  
	<div class="row">
		<div class="col-sm-6 well">
		  <h1>
		    <span class="label label-primary">
		      Question
		    </span>
		  </h1>
		    <%
		      if(currentFlashCard != null){
		    %>
		      <p>
		    <%
		        out.println(currentFlashCard.getQuestion());
		     %>
		      </p>
		     <%
		      }else {
		    %>
		      <div class="alert alert-danger">
		    <%
		        out.println("There was a problem.");
		     %>
		      </div>
		     <%
		      }
		     %>
		  
		</div>
		<div class="col-sm-6 well">
		  <h1>
		    <span class="label label-success">
		      Answer
		    </span>
		  </h1>
		    <% if(currentFlashCard != null){ %>
		      <p>
		        <%= currentFlashCard.getAnswer()%>
		      </p>
		    <%}else{ %>
		      <div class="alert alert-danger">
		        <%= "There was a problem." %>
		      </div>
		    <%} %>
		    
		</div>
	</div>
	  
</body>
</html>