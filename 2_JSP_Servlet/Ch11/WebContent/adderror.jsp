<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	계산 중 오류가 발생했습니다. <br>
	<%=exception.getMessage() %>
</body>
</html>