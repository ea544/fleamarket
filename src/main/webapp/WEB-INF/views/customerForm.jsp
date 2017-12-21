<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Registration</title>
</head>
<body>

<form:form method="POST" modelAttribute="customerForm" action="/customerForm" >
<form:hidden path="id"/>
        <h2>Registration Form</h2>
	<table>
		<tr>
			<td>Name</td>
			<td><form:input type="text" path="name" placeholder="Name" autofocus="true"></form:input>
			<br><form:errors path="name" />
			</td>
			
		</tr>
		<tr>
			<td>Email</td>
			<td><form:input type="text" path="email" placeholder="email" autofocus="true" ></form:input></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><form:input type="password" path="password" placeholder="password" autofocus="true" ></form:input>
			<br><form:errors path="password" />
			</td>
		</tr>
		
		<tr>
			<td>Street</td>
			<td><form:input type="text" path="address.street" placeholder="street" autofocus="true" ></form:input></td>
		</tr>
		
		<tr>
			<td>City</td>
			<td><form:input type="text" path="address.city" placeholder="city" autofocus="true" ></form:input></td>
		</tr>
		<tr>
			<td>state</td>
			<td><form:input type="text" path="address.state" placeholder="state" autofocus="true" ></form:input></td>
		</tr>
		<tr>
			<td>Zip</td>
			<td><form:input type="text" path="address.zip" placeholder="00000" autofocus="true" ></form:input></td>
		</tr>
		<tr>
			<td>country</td>
			<td><form:input type="text" path="address.country" placeholder="country" autofocus="true" ></form:input></td>
		</tr>
	</table>
               
        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>
</body>
</html>