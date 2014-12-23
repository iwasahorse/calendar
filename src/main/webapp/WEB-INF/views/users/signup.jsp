<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<c:url var="resourceUrl" value="/resources" />
<title>회원가입</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${resourceUrl}/bootstrap-3.3.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<style type="text/css">
</style>
<script src="${resourceUrl}/bootstrap-3.3.1/js/jquery-1.11.1.min.js"></script>
<script src="${resourceUrl}/bootstrap-3.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
        window.alert = function(){};
        var defaultCSS = document.getElementById('bootstrap-css');
        function changeCSS(css){
            if(css) $('head > link').filter(':first').replaceWith('<link rel="stylesheet" href="'+ css +'" type="text/css" />'); 
            else $('head > link').filter(':first').replaceWith(defaultCSS); 
        }
        $( document ).ready(function() {
          var iframe_height = parseInt($('html').height()); 
          window.parent.postMessage( iframe_height, 'http://bootsnipp.com');
        });
    </script>
</head>
<body>
	<div class="container">
		<div id="signupbox" style="margin-top: 50px;"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">회원 가입</div>
					<div
						style="float: right; font-size: 85%; position: relative; top: -10px">
						<a id="signinlink" href="#"
							onclick="$('#signupbox').hide(); $('#loginbox').show()"> 로그인</a>
					</div>
				</div>
				<div class="panel-body">
					<form:form action="signup" class="form-horizontal" method="post"
						commandName="userForm">
						<div id="signupalert" style="display: none"
							class="alert alert-danger">
							<p>Error:</p>
							<span></span>
						</div>

						<div class="form-group">
							<label for="email" class="col-md-3 control-label">E-mail</label>
							<div class="col-md-9">
								<form:input class="form-control" name="email" path="email"
									placeholder="Email Address" type="email" />
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="col-md-3 control-label">Password</label>
							<div class="col-md-9">
								<form:input class="form-control" name="passwd"
									placeholder="Password" path="password" type="password" />
							</div>
						</div>

						<div class="form-group">
							<label for="name" class="col-md-3 control-label"> 이름</label>
							<div class="col-md-9">
								<form:input class="form-control" name="name" placeholder=""
									path="name" type="text" />
							</div>
						</div>

						<div class="form-group">
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<button type="submit" class="btn btn-xs btn-primary">가입</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>

		</div>
	</div>

	<script type="text/javascript">
	
	</script>


</body>
</html>