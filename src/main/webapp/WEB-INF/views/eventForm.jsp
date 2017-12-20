<%@ include file="../../title.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>Insert title here</title>

  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
</head>
<body>
	<div class="jumbotron">
		<c:url var="eventFormAction" value="/event/eventForm"></c:url>
		<form:form method="POST" action="${eventFormAction}"
			modelAttribute="event">
			<table>

				<tr>
					<td>Title of the Event:</td>
					<td><form:input type="text" path="title" />
					</td>
				</tr>

				<tr>
					<td>Description:</td>
					<td><form:input type="text" path="description" /></td>
				</tr>

				<tr>
					<td>Date of the event:</td>
					<td><form:input type="text" path="date" /></td>
					
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

				 <tr>
					<td>Organizer:</td>
					<td><form:select path="organizer.id">
							<c:forEach var="org" items="${organizers}">
								<option value="${org.id}">${org.firstname}
									${org.lastname}</option>
							</c:forEach>
						</form:select></td>

				</tr>

				<form:hidden path="eventId" />
			</table>
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
  <script>
  $( function() {
	// & alert("vamos ok");
    $( "#date" ).datepicker();
  } );
  </script>
</html>