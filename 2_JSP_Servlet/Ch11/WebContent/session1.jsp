<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	session.setAttribute("age", "26");
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
	<a href="session2.jsp">session2.jsp</a>
</body>
</html>