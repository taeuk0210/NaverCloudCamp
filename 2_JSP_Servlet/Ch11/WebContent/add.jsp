<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    errorPage="adderror.jsp" %>
<%
	int num = Integer.parseInt(request.getParameter("number"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	합계 구하기
	1 부터 <%=num %> 까지의 합은 <%= num*(num+1)/2 %> 입니다.
</body>
</html>