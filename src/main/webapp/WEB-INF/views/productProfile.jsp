<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Flea Market :: Product Profile</title>
</head>
<body>
	<table>
		<tbody>
			<tr><td>${product.productName}</td></tr>
			<tr><td>${product.price}</td></tr>
			<tr><td>${product.quantity}</td></tr>
			<tr><td>${product.description}</td></tr>
		</tbody>
	</table>
	<a href="../productForm/${product.id}">Click here to edit this product</a>
</body>
</html>