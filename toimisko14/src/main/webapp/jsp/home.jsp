<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Admin CPanel - Vaalikone</title>
</head>
<body>
    <div style="text-align: center">
        <h1>Vaalikoneen admin osio</h1>
        <b>${user.fullname} (${user.email})</b>
        <br><br>
        <a href="/form.html">Muokkaa ehdokasta</a>
        <a href="/form.html">Lisää ehdokas</a>
        <a href="/form2.html">Lisää kysymyksiä</a>
        <a href="/logout">Logout</a>
    </div>
</body>
</html>