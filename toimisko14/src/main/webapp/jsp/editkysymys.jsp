<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="app.model.Ehdokas" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Read kysymys</title>
</head>
<body>

	<form action='./rest/kysymysservice/readkysymykset' method='post'>
		Kysymys:<input type='text' name='sukunimi' value='${sessionScope.kysymykset.KYSYMYKSET }'><br>
		
		<input type="hidden" name="id" value="${sessionScope.kysymys.kysymys_id }">		
		<input type='submit' name='ok' value='Edit'>
	</form>

</body>