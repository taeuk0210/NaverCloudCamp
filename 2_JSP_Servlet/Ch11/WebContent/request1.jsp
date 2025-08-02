<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" import="javax.servlet.RequestDispatcher"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	this is request1.jsp<br>
	<%
		request.setAttribute("valueInReq", "value of request1");
		RequestDispatcher dispatcher = request.getRequestDispatcher("request2.jsp");
		dispatcher.forward(request, response);
	%>
</body>
</html>