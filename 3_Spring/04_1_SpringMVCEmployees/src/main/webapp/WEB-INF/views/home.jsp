<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href="/hr/count">모든 부서 사원수 확인</a><br>
<form action="/hr/count" method="post">
	<input type="text" name="deptid">
	<button type="submit">사원수 확인</button>
</form>
</body>
</html>
