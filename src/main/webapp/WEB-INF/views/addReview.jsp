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
<title>Flea Market :: Review Item</title>
</head>
<body>
<h1>Flea Market - Add Review</h1>
	<form:form method="POST" modelAttribute="addReview" >
	<input type="hidden" name="customerId" value="${addReview.customer.id }" ></input>  
        <h2>Add Review</h2>
	<table>
		<tr>
			
		</tr>
		<tr>
			
		</tr>
		
	</table>
        <form:input type="text" path="details" placeholder="Review Text" autofocus="true" ></form:input>    
        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>
	
</body>
</html>