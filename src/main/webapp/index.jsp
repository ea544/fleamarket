<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Flea Market App</title>
</head>
<body>
	<h1>Buenos dias a todos</h1>
	<a href="${contextPath}/customerForm">Create an account</a>
	<a href="events/event">Click here to go to events</a>
		<a href="vendors">Click here to go to vendors</a>
	
	<a href="products">Click here to go to products</a>
	<a href="${contextPath}/customers">All customer</a>
</body>
</html>