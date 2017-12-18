<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FleaMarket :: Product Form</title>
</head>
<body>
	<form:form method="POST" action="/fleamarket/products/productForm" 
	modelAttribute="product" enctype="multipart/form-data">
		<form:hidden path="id" />
		<table>
			<tr>
				<td>Product name:</td>
				<td><form:input type="text" path="productName" /></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><form:input type="text" path="price" /></td>
			</tr>
			<tr>
				<td>Quantity:</td>
				<td><form:input type="text" path="quantity" /></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td>
					<form:textarea type="text" path="description"></form:textarea>
				</td>
			</tr>
		</table>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>