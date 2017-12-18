<%@ include file="../../title.jsp" %>
<title>Flea Market :: Vendor Profile</title>
</head>
<body>
	<div class="jumbotron">
		<table>
			<tbody>
				<tr><td>${vendor.firstname}</td></tr>
				<tr><td>${vendor.lastname}</td></tr>
				<tr><td>${vendor.email}</td></tr>
			</tbody>
		</table>
		<a href="">Click here to create a new event</a><br />
		<a href="/fleamarket/vendors/vendorForm/${vendor.id}">Click here to edit your profile</a>
	</div>
</body>
</html>