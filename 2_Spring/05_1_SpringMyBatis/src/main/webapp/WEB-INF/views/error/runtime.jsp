<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	실행 중 오류가 발생했습니다 T^T
	<p>Failed URL: ${uri }</p>
	<p>Exception : ${exception }</p>
	<c:forEach var="ste" items="${exception.stackTrace }">
		${ste }
	</c:forEach>
	
</body>
</html>