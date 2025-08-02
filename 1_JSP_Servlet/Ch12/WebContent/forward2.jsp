<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
	request.setAttribute("id", "rkesef");
	request.setAttribute("pw", "!23123");
	session.setAttribute("name", "kim");
	application.setAttribute("email", "sdf@sdfd.com");
	request.setAttribute("address", "서울시 강남구");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="/member3.jsp"/>
</body>
</html>