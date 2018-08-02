<%@page import="mvc.pattern.LoginBean"%>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Success</title>
</head>
<body>
	<p>You are successfully login!</p>
	<%
		LoginBean bean = (LoginBean)request.getAttribute("bean");
		out.print("Welcome " + bean.getName());
	%>
</body>
</html>