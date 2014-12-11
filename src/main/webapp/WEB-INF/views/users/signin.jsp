<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="http://getbootstrap.com/favicon.ico">
<head>
<title>Login Page</title>
<!-- Bootstrap core CSS -->
<link href="${resourceUrl}/springmvc/resources/bootstrap-3.3.1/css/bootstrap.css" rel="stylesheet"/>
<!-- Custom styles for this template -->
<link href="http://getbootstrap.com/examples/signin/signin.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="http://getbootstrap.com/assets/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>


	<div id="login-box">
 
		<h3>Login with Username and Password</h3>
 
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
 
 	
		<form name='loginForm' action="<c:url value='/j_spring_security_check' />" method='POST'>
 
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='id'></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit" value="submit" /></td>
			</tr>
		  </table> 
		</form>
	</div>


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="http://getbootstrap.com//assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>

</html>

