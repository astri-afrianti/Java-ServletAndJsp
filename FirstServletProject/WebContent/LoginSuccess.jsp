<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login success page</title>
</head>
<body>
<%
// allow access only if session exists
String user = (String) session.getAttribute("user");

if(user == null) {
	response.sendRedirect("Login.html");
} 

String username = null;
String sessionId = null;
Cookie[] cookies = request.getCookies();
if (cookies != null) {
	for(Cookie cookie: cookies){
		if(cookie.getName().equals("user")) {
			username = cookie.getValue();
		}
		
		if (cookie.getName().equals("JSESSIONID")) {
			sessionId = cookie.getValue();
		}
	}
} 

if (username == null) response.sendRedirect("Login.html");
%>
	<h3>Hi <%=username %>, Login successful.</h3>
	
	<br>
	<a href="CheckoutPage.jsp">Checkout Page</a>
	<form action="LogoutServlet" method="post">
		<input type="submit" value="Logout">
	</form>
</body>
</html>