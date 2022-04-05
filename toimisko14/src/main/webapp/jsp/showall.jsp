<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="app.model.Ehdokas" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All datatable rows</title>
</head>
<body>

<table>
<tr>
	<th>ID</th>
	<th>Sukunimi</th>
	<th>Etunimi</th>
	<th>Puolue</th>
	<th>Kotipaikkakunta</th>
	<th>Ika</th>
	<th>Miksi_eduskuntaan</th>
	<th>Mita_asioita_haluat_edistaa</th>
	<th>Ammatti</th>
</tr>
<c:forEach var="ehdokas" items="${sessionScope.allgames }">
	<tr>
		<td>${ehdokas.id }</td>
		<td>${ehdokas.sukunimi }</td>
		<td>${ehdokas.etunimi }</td>
		<td>${ehdokas.puolue }</td>
		<td>${ehdokas.kotipaikkakunta }</td>
		<td>${ehdokas.ika }</td>
		<td>${ehdokas.miksi_eduskuntaan }</td>
		<td>${ehdokas.mita_asioita_haluat_edistaa }</td>
		<td>${ehdokas.ammatti }</td>
		<td>
			<a href="/editehdokas?id=${ehdokas.id }">Edit</a>
		</td>
	</tr>
</c:forEach>
</table>

</body>
</html>