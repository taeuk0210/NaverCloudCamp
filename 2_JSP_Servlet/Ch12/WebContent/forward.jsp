<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="com.member.MemberDTO" %>
    
<%
	request.setCharacterEncoding("utf-8");
	request.setAttribute("address", "서울시 강남구");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="m1" class="com.member.MemberDTO"/>
	<jsp:setProperty property="*" name="m1"/>
	<%request.setAttribute("m", m1); %>
	<jsp:forward page="/member2.jsp"/>
</body>
</html>