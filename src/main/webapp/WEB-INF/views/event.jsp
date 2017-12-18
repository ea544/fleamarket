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
	<c:url var="deleteEventFunction" value="/event/deleteEvent" ></c:url>
	<c:url var="getEventFunction" value="/event/getForm" ></c:url>
	<table>
		<tbody>
			<tr>
				<th>Id</th>
				<th>Title</th>
				<th>Description</th>
				<th>Date</th>
				<th>Event cost</th>
				<th>Subscription Fee</th>
				<th>Review</th>
				<th>Organizer</th>
				<th>Vendors</th>
			</tr>
			<c:forEach var="event" items="${events}">


				<tr>
					<td>${event.eventId}</td>
					<td>${event.title}</td>
					<td>${event.description}</td>
					<td></td>
					<td>${event.organizingCostEstimate}</td>
					<td>${event.subscriptionFee}</td>
					<td>${event.review}</td>
					<td>${event.organizer.firstname}</td>
					<td>
					<c:forEach var="vendor" items="${event.vendors}">
					 - ${vendor.firstname}
					</c:forEach>
					</td>
					<td> <a href="${getEventFunction}/${event.eventId}">Edit</a></td>
					<td> <a href="${deleteEventFunction}/${event.eventId}">Delete</a> </td>
					<td> <a href="${deleteEventFunction}/${event.eventId}">Add Vendors</a> </td>
				</tr>
			</c:forEach>
		<tbody>
	</table>
	<a href="eventForm">Click here to create an event</a>
	<br>
	<a href="eventForm">Click here to search an event</a>
</body>
</html>