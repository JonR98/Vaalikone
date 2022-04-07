<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="app.model.Ehdokas" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Poista ehdokas</title>
</head>
<body>

		<form action="/poistaehdokas" method="post">
		Are you sure you want to delete?
		
    <input type="hidden" name="id" value="<%=request.getParameter("id")%>" />
    <input type="submit" value="Delete" />
</form>


</body>
</html>