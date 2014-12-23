<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<c:url var="resourceUrl" value="/resources" />
<link href="${resourceUrl}/bootstrap-3.3.1/css/bootstrap.css"
	rel="stylesheet" />
<link
	href="${resourceUrl}/bootstrap-3.3.1/css/bootstrap-datetimepicker.css"
	rel="stylesheet" />
<link href="${resourceUrl}/css/custom.css" rel="stylesheet" />
<c:set var="pageTitle" value="All Events" scope="request" />
<style>
td{text-align: center}
th{text-align: center}
</style>
</head>
<body class="header">
	<div class="container">

		<jsp:include page="../includes/header.jsp" />
		<p>모든 유저들이 등록한 이벤트를 볼 수 있습니다. </p>
		<c:url var="createUrl" value="/events/form" />
		<div id="create" class="pull-right">
			<a href="${createUrl}">이벤트 생성하기</a>
		</div>
		<table class="table table-bordered table-striped table-condensed">
			<thead>
				<tr>
					<th>날짜/시간</th>
					<th>주최자</th>
					<th>요약</th>
					<th>상세</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty events}">
					<tr>
						<td colspan="2" class="msg">등록된 이벤트가 없습니다.</td>
					</tr>
				</c:if>
				<c:forEach items="${events}" var="event">
					<tr>
						<fmt:formatDate value="${event.when.time}" type="both"
							pattern="yyyy-MM-dd HH:mm" var="when" />
						<td><c:out value="${when}" /></td>
						<td><c:out value="${event.owner.name}" /></td>
						<c:url var="eventUrl" value="${event.id}" />
						<td><c:out value="${event.summary}" /></td>
						<td><c:out value="${event.description}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<jsp:include page="../includes/footer.jsp" />
	</div>
</body>
</html>