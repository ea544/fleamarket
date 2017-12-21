<%@ include file="../../title.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<title>Flea Market :: Login</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 class="text-center login-title">Sign in to Flea Market</h1>
            <div class="account-wall">
            	<c:if test="${ not empty error}">
					<div class="alert alert-danger">
						<spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials" />
					</div>
				</c:if>
                <img  class="img-responsive center-block" height="50" width="40" src="<c:url value="resources/images/logo.png" />" />
                <form class="form-signin" 
						action="<spring:url value="/login"></spring:url>"
						method="POST">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="text" name="username" class="form-control" placeholder="Email" required autofocus />
                <input type="password" name="password" class="form-control" placeholder="Password" required />
                <button class="btn btn-lg btn-primary btn-block" type="submit" >
                    Sign in</button>
                
                <a href="#" class="pull-right need-help">Need help? </a><span class="clearfix"></span>
                </form>
            </div>
            <a href="customerForm" class="text-center new-account">Or create a new account</a>
        </div>
    </div>
</div>
</body>
</html>