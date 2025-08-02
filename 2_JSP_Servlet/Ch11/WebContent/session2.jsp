<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String age=(String)session.getAttribute("age");
	String name=(String)session.getAttribute("name");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	이름은 <%=name %>.<br>
	나이는 <%=age %>.<br>
</body>
</html>