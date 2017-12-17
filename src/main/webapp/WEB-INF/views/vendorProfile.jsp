<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Flea Market :: Vendor Profile</title>
</head>
<body>
	<table>
		<tbody>
			<tr><td>${vendor.firstname}</td></tr>
			<tr><td>${vendor.lastname}</td></tr>
			<tr><td>${vendor.email}</td></tr>
		</tbody>
	</table>
	<a href="">Click here to create a new event</a><br />
	<a href="/vendors/vendorForm/${vendor.id}">Click here to edit your profile</a>
</body>
</html>