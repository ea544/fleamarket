<%@ include file="../../title.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html xmlns:th="http://www.thymeleaf.org">
<title>FleaMarket :: Vendor Form</title>
</head>
<body>
	<div class="jumbotron">
	<form:form method="POST" action="/fleamarket/vendors/vendorForm" modelAttribute="vendor">
		<form:hidden path="id"/>
		<table>
			<tr>
				<td>First name:</td>
				<td><form:input type="text" path="firstname" /><br>
				<form:errors path="firstname" /></td>
			</tr>
			<tr>
				<td>Last name:</td>
				<td><form:input type="text" path="lastname" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input type="text" path="email" /><br>
				<form:errors path="email" /></td>
			</tr>
		</table>
		<input type="submit" value="Submit"/>
	</form:form>
	</div>
	
</body>
</html>