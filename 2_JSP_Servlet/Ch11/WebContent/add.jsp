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
	�հ� ���ϱ�
	1 ���� <%=num %> ������ ���� <%= num*(num+1)/2 %> �Դϴ�.
</body>
</html>