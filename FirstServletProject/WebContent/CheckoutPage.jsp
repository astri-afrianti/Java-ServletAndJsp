<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
// allow access only if session exists
String user = (String) session.getAttribute("user");

if(user == null) {
	response.sendRedirect("Login.html");
} 

%>
	<h3>Hi <%=user %>, do the checkout.</h3>
	<br>
	<form action="LogoutServlet" method="post">
		<input type="submit" value="Logout" >
	</form>
</body>
</html>