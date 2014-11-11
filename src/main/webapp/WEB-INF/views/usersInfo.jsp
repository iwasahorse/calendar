<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType ="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<table border="0">

<c:forEach var="user" items="${users}" varStatus="status">
<tr>
	<td align="center" class="listtd"><c:out value="${status.count}"/></td>
	<td align="center" class="listtd"></td>
	<td align="left" class="listtd"><c:out value="${user.name}"/> </td>
	<td align="center" class="listtd"><c:out value="${user.id}"/> </td>
	<td align="center" class="listtd"><c:out value="${user.email}"/> </td>
	<td align="center" class="listtd"><c:out value="${user.level}"/> </td>
	<td align="center" class="listtd"><c:out value="${user.login}"/> </td>
	<td align="center" class="listtd"><c:out value="${user.recommend}"/> </td>

</tr>

</c:forEach>
</table>
</body>
</html>
