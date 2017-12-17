<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>List of events so far :)</h1>
	<table>
		<tbody>
			<tr>
				<td>Title:</td>
				<td>${events.title}</td>
			</tr>

			<tr>
				<td>Description:</td>
				<td>${event.description}</td>
			</tr>


			<tr>
				<td>Organizing Cost Estimate:</td>
				<td>${event.organizingCostEstimate}</td>
			</tr>

			<tr>
				<td>Subscription Fee:</td>
				<td>${event.subscriptionFee}</td>
			</tr>


			<tr>
				<td>Review:</td>
				<td>${event.review}</td>
			</tr>


			<tr>
				<td>Organizer:</td>
				<td>${event.organizer}</td>
			</tr>
		<tbody>
	</table>
	<a href="events/eventForm">Click here to create an event</a>
	<br>
	<a href="events/eventForm">Click here to edit an event</a>
	<br>
	<a href="events/eventForm">Click here to delete an event</a>
	<br>
	<a href="events/eventForm">Click here to search an event</a>
</body>
</html>