<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type"content="text/html; charset=UTF-8">
<title>ch04 : 계산기</title>
</head>

<body>
<CENTER>
<H3>계산기</H3>
<HR>
<form action=http://localhost:8181/FirstJSP/CalServlet method=post>

<INPUT type="text" name="num1" width=200 size="5">
<SELECT name="operator">
	<option selected>+</option>
	<option>-</option>
	<option>*</option>
	<option>/</option>
</SELECT>
<INPUT type="text" name="num2" width=200 size="5">
<INPUT type="submit" value="계산" name="B1"><INPUT type="reset" value="다시 입력" name="B2">
</form>
</CENTER>
</body>
</html>