<%@ include file="../../title.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<title>Please Login</title>
</head>
<body>
<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
	<div class="modal-dialog">
			<div class="loginmodal-container">
				<h1>Login to Your Account</h1><br>
			  <form method="post" command="" action="<c:url value='j_spring_security_check' />">
				User: <input name="username"
				value='<c:if test="${not empty param.login_error}">
				<c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>'/>
				<br />
				Pass: <input type="password" name='password' />
				<br />
				<input type="submit" />
				</form>
			  <div class="login-help">
				<a href="#">Register</a> - <a href="#">Forgot Password</a>
			  </div>
			</div>
		</div>
	</div>
	<!-- -->
</body>
</html>