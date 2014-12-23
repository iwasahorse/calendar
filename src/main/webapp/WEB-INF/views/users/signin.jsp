<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<!--  meta charset="utf-8" -->
<!-- 
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="http://getbootstrap.com/favicon.ico">
-->
<head>
<title>Sign-in Page</title>
<!-- Bootstrap core CSS -->
<c:url var="resourceUrl" value="/resources"/>
<link
	href="${resourceUrl}/bootstrap-3.3.1/css/bootstrap.css"
	rel="stylesheet" />
<!-- Custom styles for this template -->
<link href="${resourceUrl}/css/signin.css"
	rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script
	src="http://getbootstrap.com/assets/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div class="container">

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

	<form class="form-signin" role="form" action="<c:url value='/j_spring_security_check' />" method='POST'>
			<h2 class="form-signin-heading"></h2>
			<label for="email" class="sr-only">input E-mail</label> <input
				type="email" name="email" class="form-control" placeholder="E-mail"
				required autofocus> <label for="inputPassword"
				class="sr-only">Password</label> <input type="password"
				name="password" class="form-control" placeholder="Password"
				required>
			<div class="checkbox">
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit" value="submit">
				로그인</button>
		</form>

	</div>
	<!-- /container -->



	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script
		src="http://getbootstrap.com/assets/js/ie10-viewport-bug-workaround.js"></script>
</body>

</html>

