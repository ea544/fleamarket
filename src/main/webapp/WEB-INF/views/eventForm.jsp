<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="POST" action="eventForm" modelAttribute="event">
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
				<td>Review:</td>
				<td><form:input type="text" path="review" /></td>
			</tr>

			<tr>
				<td>Organizer:</td>
				<td><form:input type="text" path="organizer" /></td>
			</tr>


		</table>
		<input type="submit" value="Submit" />
	</form:form>

</body>
</html>