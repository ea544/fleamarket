<%@ include file="title.jsp" %>
<%! int counter; %> 
<title>Flea Market App</title>
</head>
<body>
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" 
	      data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="#">
	      <img  height="50" width="40" src="<c:url value="resources/images/logo.png" />" /></a><h3>Flea Market Happenings</h3>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav navbar-right">
	      	<li><a href="login">Login</a></li>
	      	<li><a href="customerForm">Register</a></li>
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" 
	          role="button" aria-haspopup="true" aria-expanded="false">Actions <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li class="active"><a href="<c:url value="event/eventList" />">Events<span class="sr-only">(current)</span></a></li>
		        <li><a href="vendors">Vendors/Customers Profile</a></li>
		        <li><a href="customers">Customers</a></li>
		        <li role="separator" class="divider"></li>
		        <li><a href="login">Login</a></li>
				<li><a href="customerForm">Customer Register</a></li>
	          </ul>
	        </li>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
	<div class="container" id="tourpackages-carousel">
		<div class="row">
		<%
	        Integer[] list = {1,2,3,4,5,6,7,8,9,10};
	    %>
	    <%for (counter = 1; counter <= list.length; counter++ ) {
	    	if( counter % 5 == 0) {%>
	    		</div><div class="row">
	    	<% } else {%>
	    		<div class="col-xs-18 col-sm-6 col-md-3">
		          <div class="thumbnail">
		            <img src="http://placehold.it/500x300" alt="">
		              <div class="caption">
		                <h4>Thumbnail label</h4>
		                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. </p>
		                <p><a href="#" class="btn btn-info btn-xs" role="button">Details</a> 
		                <a href="#" class="btn btn-default btn-xs" role="button">Review</a></p>
		            </div>
		          </div>
		        </div>	
	    	<% }%>
	    <%}%>
	    </div>
    </div><!-- End container -->
    <script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>