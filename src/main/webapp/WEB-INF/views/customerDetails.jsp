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
<h1>Flea Market </h1>
	<table border="1">
		<tbody>
		<tr><td colspan="5">${customer.name} Reviews</td></tr>
		<tr>
		<td>ID</td>
		<td>Review</td>
		<td>Product</td>
		
		</tr>
		<c:forEach var="review" items="${customer.reviews}">
			<tr>
				<td>${review.id}</td>
				<td>${review.details}</td>
				<td>${review.product.productName}</td>
				
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
</body>
</html>