<%@ include file="../../title.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FleaMarket :: Subscribe to Event</title>
</head>
<body>
	<div class="jumbotron">
		<table class="table table-stripped table-hover">
			<thead>
				<tr><th>Event</th><th>Date</th><th>Location</th><th>Action</th></tr>
			</thead>
			<tbody>
				<c:forEach items="${events}" var="event">
					<tr>
						<td>${event.title}</td>
						<td>${event.date }</td>
						<td>${event.address.city }</td>
						<td><a href="<c:url value="/vendors/vendor/${vendorId}/availableEvents/${event.eventId}"/>">Subscribe</a></td>
				</c:forEach>	
			</tbody>
		</table>
		
	</div>
</body>
</html>