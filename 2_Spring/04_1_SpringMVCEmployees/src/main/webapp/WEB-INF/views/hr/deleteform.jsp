<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사원 정보 삭제</h1>
	<p>${emp.employeeId } 사원 ${emp.firstName} ${emp.lastName } 의 정보를 삭제합니다.</p>
	<p>삭제후 데이터는 복구될 수 없습니다.</p>
	<p>${emp.employeeId }사원의 이메일을 입력하세요.</p>
	<form action="./delete" method="post">
		이메일 : <input type="text" name="email"/>
		<input type="hidden" name="empid" value="${emp.employeeId }"/>
		<input type="submit" value="삭제"/>
	</form>
</body>
</html>