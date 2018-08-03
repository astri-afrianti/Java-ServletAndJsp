<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Custom Tag Example</title>
<%@ taglib uri="http://localhost:8080/jsp/tlds/mytags" prefix="mytags"%>
</head>
<body>
	<h2>Number Formatting Example</h2>
	
	<mytags:formatNumber number="100050.574" format="#,###.00"/><br><br>
	
	<mytags:formatNumber number="1234.567" format="$# ###.00"/><br><br>
	
	<p><strong>Thank You!!</strong></p>
</body>
</html>