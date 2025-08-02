<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String valueInSession=(String)session.getAttribute("valueInSession");
	String valueInApp=(String)application.getAttribute("valueInApp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	session value : <%= valueInSession %><br>
	application value : <%= valueInApp %>
</body>
</html>