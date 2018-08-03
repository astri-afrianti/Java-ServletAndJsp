<%@ page import=" java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Practice</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<% 	
	List<String> names = new ArrayList<String>();
	names.add("Astri");
	names.add("Arian");
	pageContext.setAttribute("names", names);
%>
	<h1>EL Practice</h1>
	<strong>Simple . EL Example:</strong> ${requestScope.person}
	<br><br>
	<strong>Simple . EL Example without scope:</strong> ${person}
	<br><br>
	<strong>Simple [] Example:</strong> ${applicationScope["UserCookie"]}
	<br><br>
	<strong>Multiples . EL Example:</strong> ${sessionScope.employee.address.address}
	<br><br>
	<strong>List EL Example:</strong> ${names[1]}
	<br><br>
	<strong>Header information EL Example:</strong> ${header["Accept-Encoding"]}
	<br><br>
	<strong>Cookie EL Example:</strong> ${cookie["UserCookie"].value}
	<br><br>
	<strong>pageContext EL Example:</strong> HTTP Method is ${pageContext.request.method}
	<br><br>
	<strong>Context param EL Example:</strong> ${initParam.AppID}
	<br><br>
	<strong>Arithmetic Operator EL Example:</strong> ${initParam.AppID + 200}
	<br><br>
	<strong>Relational Operator EL Example:</strong> ${initParam.AppID < 200}
	<br><br>
	<strong>Arithmetic Operator EL Example:</strong> ${initParam.AppID + 200}
	<br><br>
	
	<h1>JSTL Practice</h1>
	<h2>c:foreach Loop Sample</h2>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Role</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.personArray}" var="emp">
			<tr>
				<td>
					<c:out value="${emp.getId()}"></c:out>
				</td>
				<td>
					<c:out value="${emp.getName()}"></c:out>
				</td>
				<td>
					<c:out value="${emp.getRole()}"></c:out>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<br><br>
	
	<h2>c:if If statement sample</h2>
	<c:if test="${requestScope.htmlTagData ne null }">
		<c:out value="${requestScope.htmlTagData}" escapeXml="true"></c:out>
	</c:if>
	<br><br>
	
	<h2>c:set Example to set variable value</h2>
	<c:set var="id" value="5" scope="request"></c:set>
	<c:out value="${requestScope.id }"></c:out>
	<br><br>
	
	<h2>c:catch catch sample</h2>
	<c:catch var="exception">
		<% int x = 5/0; %>
	</c:catch>
	<c:if test="${exception ne null }">
		<p>Exception is: ${exception} <br>
			Exception Message: ${exception.message}
		</p>
	</c:if>
	<br><br>
	
	<h2>c:url Example</h2>
	<a href='<c:url value="${requestScope.url }"></c:url>'>
		Journal Dev
	</a>
	<br><br>
</body>
</html>