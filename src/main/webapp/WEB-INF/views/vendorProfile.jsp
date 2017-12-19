<%@ include file="../../title.jsp" %>
<title>Flea Market :: Vendor Profile</title>
</head>
<body>
	<div class="jumbotron">
		<table>
			<thead>
				<tr><td>Welcome: ${vendor.lastname}, ${vendor.firstname} :: ${vendor.email}</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<ul class="list-group">
						  <li class="list-group-item"><a href="<c:url value="/event/eventForm" />">Click here to create an event</a></li>
						  <li class="list-group-item"><a href="<c:url value="/products/productForm" />">Create a Product</a></li>
						  <li class="list-group-item">
						  	<a href="<c:url value="/event/eventList" />">Subscribe to a Flea Market</a>
						  </li>
						  <li class="list-group-item"><a href="<c:url value="/vendors/vendorForm/${vendor.id}" />">Update Profile</a></li>
						</ul>
					</td>
				</tr>
			</tbody>
		</table>
		
	</div>
</body>
</html>