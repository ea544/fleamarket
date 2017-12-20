<%@ include file="../../title.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<title>FleaMarket :: Product Form</title>
</head>
<body>
	<div class="jumbotron">
		<form:form method="POST" action="/fleamarket/products/productForm" 
		modelAttribute="product">
			<form:hidden path="id" />
			<table>
				<tr>
					<td>Product name:</td>
					<td><form:input type="text" path="productName" /><br>
				<form:errors path="productName" /></td>
				</tr>
				<tr>
					<td>Price:</td>
					<td><form:input type="text" path="price" /></td>
				</tr>
				<tr>
					<td>Quantity:</td>
					<td><form:input type="text" path="quantity" /></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td>
						<form:textarea type="text" path="description"></form:textarea>
					</td>
				</tr>
			</table>
			<input type="submit" value="Submit"/>
		</form:form>
	</div>
</body>
</html>