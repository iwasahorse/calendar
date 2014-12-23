<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Success</title>
</head>
<body>
    <div align="center">
        <table border="0">
            <tr>
                <td colspan="2" align="center"><h2>회원 가입이 완료됐습니다!</h2></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <h3>입력하신 정보는 다음과 같습니다.</h3>
                </td>
            </tr>
            <tr>
                <td>User Name:</td>
                <td>${userForm.name}</td>
            </tr>
            <tr>
                <td>E-mail:</td>
                <td>${userForm.email}</td>
            </tr>
        </table>
        <a href="/springmvc/">메인 화면으로 돌아가기</a>
    </div>
</body>
</html>