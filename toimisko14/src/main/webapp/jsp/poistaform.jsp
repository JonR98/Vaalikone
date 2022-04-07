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
        <input type="hidden" name="id" value="<%=request.getParameter("ika")%>" />
    sukunimi:<input type='hidden' name='sukunimi' value='${sessionScope.ehdokas.sukunimi }'><br>
		etunimi:<input type='hidden' name='etunimi' value='${sessionScope.ehdokas.etunimi }'><br>
		puolue:<input type='hidden' name='puolue' value='${sessionScope.ehdokas.puolue }'><br>
		kotipaikkakunta:<input type='hidden' name='kotipaikkakunta' value='${sessionScope.ehdokas.kotipaikkakunta }'><br>
		ika:<input type='hidden' name='ika' value='${sessionScope.ehdokas.ika }'><br>
		Miksi_eduskuntaan?:<input type='hidden' name='miksi_eduskuntaan' value='${sessionScope.ehdokas.miksi_eduskuntaan }'><br>
		Mita_asioita_haluat_edistaa?:<input type='hidden' name='mita_asioita_haluat_edistaa' value='${sessionScope.ehdokas.mita_asioita_haluat_edistaa }'><br>
		ammatti:<input type='hidden' name='ammatti' value='${sessionScope.ehdokas.ammatti }'><br>
		<input type="hidden" name="id" value="${sessionScope.ehdokas.id }">		
    <input type="submit" value="Delete" />
</form>


</body>
</html>