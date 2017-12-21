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
	<form:form method="POST" action="/fleamarket/products/photos/photosForm" 
	modelAttribute="productProxy" enctype="multipart/form-data">
		<form:hidden path="id" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<table>
			<tr>
				<td>Photo 1:</td>
				<td><form:input type="file" path="photos" multiple="multiple" /></td>
			</tr>
		</table>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>