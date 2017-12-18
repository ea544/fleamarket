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
	<form:form method="POST" action="/fleamarket/products/photosForm" 
	modelAttribute="product" enctype="multipart/form-data">
		<form:input type="text" path="id" />
		<table>
			<tr>
				<td>Photo 1:</td>
				<td><form:input type="file" path="photos" /></td>
			</tr>
			<tr>
				<td>Photo 2:</td>
				<td><form:input type="file" path="photos" /></td>
			</tr>
			<tr>
				<td>Photo 2:</td>
				<td><form:input type="file" path="photos" /></td>
			</tr>
		</table>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>