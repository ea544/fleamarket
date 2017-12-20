<%@ include file="../../title.jsp" %>
<title>Insert title here</title>
</head>
<body>
<div class="jumbotron"> 
	<h2>List of events so far :)</h2>
	<c:url var="deleteEventFunction" value="/event/deleteEvent" ></c:url>
	<c:url var="getEventFunction" value="/event/getForm" ></c:url>
	<c:url var="addVendorFunction" value="/event/eventAddVendor" ></c:url>
	<c:url var="addEventFunction" value="/event/eventForm" ></c:url>
	<table class="table table-stripped table-bordered table-hover">
		<tbody class="">
			<tr>
				<th>Id</th>
				<th>Title</th>
				<th>Description</th>
				<th>Date</th>
				<th>Event cost</th>
				<th>Subscription Fee</th>
				<th>Street</th>
				<th>City</th>
				<th>State</th>
				<th>Zip Code</th>
				<th>Country</th>
				<th>Review</th>
				<th>Organizer</th>
				<th>Vendors</th>
			</tr>
			<c:forEach var="event" items="${events}">


				<tr>
					<td>${event.eventId}</td>
					<td>${event.title}</td>
					<td>${event.description}</td>
					<td>${event.date}</td>
					<td>${event.organizingCostEstimate}</td>
					<td>${event.subscriptionFee}</td>
					<td>${event.address.street}</td>
					<td>${event.address.city}</td>
					<td>${event.address.state}</td>
					<td>${event.address.zip}</td>
					<td>${event.address.country}</td>
					<td>${event.review}</td>
					<td>${event.organizer.id}</td>
					<td>
					<c:forEach var="vendor" items="${event.vendors}">
					 - ${vendor.firstname}
					</c:forEach>
					</td>
					<td> <a href="${deleteEventFunction}/${event.eventId}">Delete</a> </td>
					<td> <a href="${getEventFunction}/${event.eventId}">Edit</a></td>
					<td> <a href="${addVendorFunction}/${event.eventId}">Vendors</a> </td>
				</tr>
			</c:forEach>
		<tbody>
	</table>
	<a href="${addEventFunction}">Click here to create an event</a>
	</div>
</body>

</html>