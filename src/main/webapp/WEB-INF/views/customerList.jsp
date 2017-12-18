<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Flea Market :: Customer Details</title>
</head>
<body>
	<table>
		<tbody>
		<th><td>Name</td><td>E-mail</td><td>Street</td><td>City</td><td>Action</td></th>
		<c:forEach var="customer" items="${customers}">
			<tr><td>${customer.name}</td>
			<td>${customer.email}</td>
			<td>${customer.address.street}</td>
			<td>${customer.address.city}</td>
			<td><a href="../customerDetails/${customer.email}">view customer details</a></td>
			
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>