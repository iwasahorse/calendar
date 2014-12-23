<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="pageTitle" scope="request">
    <c:out value="Event - ${event.summary}"/>
</c:set>

<jsp:include page="../includes/header.jsp"/>
<dl>
    <dt>Owner</dt>
    <dd id="owner"><c:out value="${event.owner.lastName}, ${event.owner.firstName}"/></dd>
    <dt>Attendee</dt>
    <dd id="attendee"><c:out value="${event.attendee.lastName}, ${event.attendee.firstName}"/></dd>
    <dt>When</dt>
    <fmt:formatDate value="${event.when.time}" type="both" pattern="yyyy-MM-dd HH:mm" var="when"/>
    <dd id="when"><c:out value="${when}"/></dd>
    <dt>Message Details</dt>
    <dd id="owner"><c:out value="${event.description}"/></dd>
</dl>
<jsp:include page="../includes/footer.jsp"/>