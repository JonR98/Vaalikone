<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="app.model.Ehdokas" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit ehdokas</title>
</head>
<body>

	<form action='./editehdokas' method='post'>
		sukunimi:<input type='text' name='sukunimi' value='${sessionScope.ehdokas.sukunimi }'><br>
		etunimi:<input type='text' name='etunimi' value='${sessionScope.ehdokas. }'><br>
		puolue:<input type='text' name='puolue' value='${sessionScope.ehdokas.puolue }'><br>
		kotipaikkakunta:<input type='text' name='kotipaikkakunta' value='${sessionScope.ehdokas.kotipaikkakunta }'><br>
		ika:<input type='text' name='ika' value='${sessionScope.ehdokas.ika }'><br>
		Miksi_eduskuntaan?:<input type='text' name='miksi_eduskuntaan' value='${sessionScope.ehdokas.miksi_eduskuntaan }'><br>
		Mita_asioita_haluat_edistaa?:<input type='text' name='mita_asioita_haluat_edistaa' value='${sessionScope.ehdokas.mita_asioita_haluat_edistaa }'><br>
		ammatti:<input type='text' name='ammatti' value='${sessionScope.ehdokas.ammatti }'><br>
		<input type="hidden" name="id" value="${sessionScope.ehdokas.id }">		
		<input type='submit' name='ok' value='Edit'>
	</form>

</body>
</html>