<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:url var="eventFormAction" value="/event/eventForm" ></c:url>
	<form:form method="POST" action="${eventFormAction}" modelAttribute="event">
		<table>

			<tr>
				<td>Title of the Event:</td>
				<td><form:input type="text" path="title" /></td>
			</tr>

			<tr>
				<td>Description:</td>
				<td><form:input type="text" path="description" /></td>
			</tr>

			<tr>
				<td>Cost:</td>
				<td><form:input type="text" path="organizingCostEstimate" /></td>
			</tr>

			<tr>
				<td>Fee:</td>
				<td><form:input type="text" path="subscriptionFee" /></td>
			</tr>

			<tr>
				<td>Organizer:</td>
				<td><form:input type="text" path="organizer.firstname" /></td>
			</tr>

			<h2>Address Information:</h2>

			<tr>
				<td>Street:</td>
				<td><form:input type="text" path="address.street" /></td>
			</tr>

			<tr>
				<td>City:</td>
				<td><form:input type="text" path="address.city" /></td>
			</tr>

			<tr>
				<td>State:</td>
				<td><form:input type="text" path="address.state" /></td>
			</tr>
			
			<tr>
				<td>Zip:</td>
				<td><form:input type="text" path="address.zip" /></td>
			</tr>

			<tr>
				<td>Country:</td>
				<td><form:input type="text" path="address.country" /></td>
			</tr>

			<tr>
				<td>Review:</td>
				<td><form:input type="text" path="review" /></td>
			</tr>

<form:hidden path="eventId"/>

		</table>
		<input type="submit" value="Submit" />
	</form:form>

</body>
</html>