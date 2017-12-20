<%@ include file="../../title.jsp" %>
<title>Flea Market :: Product Profile</title>
</head>
<body>
	<div class="jumbotron">
		<div class="panel panel-default">
			  <div class="panel-heading">
			    <h3 class="panel-title">${product.productName}</h3>
			  </div>
			  <div class="panel-body">
				    <div class="list-group">
					  <button type="button" class="list-group-item"><span class="label label-default">Price:</span> ${product.price}</button>
					  <button type="button" class="list-group-item"><span class="label label-default">Quantity:</span> ${product.quantity}</button>
					  <button type="button" class="list-group-item"><span class="label label-default">Description:</span> ${product.description}</button>
					</div>					
					<div class="row">
				  <div class="col-xs-6 col-md-3">
				  	<c:forEach items="${product.photos}" var="image" >
					    <a href="#" class="thumbnail">
					      <img src="<c:url value="/photo/${image}" />" alt="${image}" />
					    </a>
				    </c:forEach>
				  </div>
				  ...
				</div>
					
			  </div>
		</div>
	<a href="/fleamarket/products/photos/photosForm/${product.id }">Add photos for the product</a><br>
	<a href="../productForm/${product.id}">Click here to edit this product</a>
	</div>
</body>
</html>