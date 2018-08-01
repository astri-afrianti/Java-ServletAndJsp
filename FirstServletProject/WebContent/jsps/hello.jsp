<%@page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Hello</title>
</head>
<body>
	<h2>Hi There</h2>
	<br>
	<h3>Date :</h3> <%= new Date() %>
	Server info: <%= application.getServerInfo() %><br>
	Servlet version: <%= application.getMajorVersion() %>.<%= application.getMinorVersion() %><br>
	JSP version: <%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %><br>
	Java version: <%= System.getProperty("java.version") %><br>
	
</body>
</html>