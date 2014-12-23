<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<c:set var="pageTitle" value="Welcome to myCalendar!" scope="request" />
<html lang="ko" xmlns:th="http://www.thymeleaf.org">
<head>
<title>myCalendar: <c:out value="${pageTitle}" />
</title>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<c:url var="resourceUrl" value="/resources" />
<link href="${resourceUrl}/bootstrap-3.3.1/css/bootstrap.css"
	rel="stylesheet" />
<link
	href="${resourceUrl}/bootstrap-3.3.1/css/bootstrap-datetimepicker.css"
	rel="stylesheet" />
<link href="${resourceUrl}/css/custom.css" rel="stylesheet" />
<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<script type="text/javascript"
	src="${resourceUrl}/bootstrap-3.3.1/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
	src="${resourceUrl}/bootstrap-3.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${resourceUrl}/bootstrap-3.3.1/js/moment.js"></script>
<script type="text/javascript"
	src="${resourceUrl}/bootstrap-3.3.1/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript">
	$(function() {
		$('#datetimepicker5').datetimepicker();
	});
</script>
</head>
<body class="header">
	<div class="container">
		<jsp:include page="../includes/header.jsp" />
		<c:if test="${message != null}">
			<div class="alert alert-success" id="message">
				<c:out value="${message}" />
			</div>
		</c:if>
		<form:form action="form" method="post" commandName="eventform">
			<div class="container" style="margin-top: 10px; margin-bottom: 10px">



				<div id='datetimepicker5' style="padding: 10px 0px;">
					<input type='text' size="30" name="eventtime"
						data-date-format="YYYY-MM-DD HH:mm" readonly/> <input type="hidden"
						class="input-group-addon" /> <span
						class="glyphicon glyphicon-calendar"></span>
				</div>



				<div>이벤트 요약</div>
				<div style="padding: 10px 0px;">
					<form:input placeholder="" class="form-control" type="text"
						path="summary" style="width: 150px;"/>
				</div>

				<div>이벤트 상세</div>
				<div style="padding: 10px 0px;">
					<form:textarea path="description" id="t_area" cols="85" rows="3"
						maxlength="255"/>
				</div>



				<div class="form-group">
					<button type="submit" class="btn btn-sm btn-primary">이벤트
						생성</button>
				</div>



			</div>

		</form:form>
	</div>
	<jsp:include page="../includes/footer.jsp" />



</body>
</html>