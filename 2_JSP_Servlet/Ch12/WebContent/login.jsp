<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>Insert title here</title>
<style>
	#reg, table, td, tr {
	text-align:center;
	border: 20px #000;
	font-size: 20px;
	margin-left: auto;
	margin-right: auto;
	}
	
</style>
</head>
<body>
<div id = "reg">
<h3>회원 가입 창</h3>
<form action="/Ch12/forward.jsp" method="post">
	<fieldset>
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" size="20"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw" size="20"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" size="20"></td>
			</tr>
			<tr>
				<td>메일</td>
				<td><input type="text" name="email" size="20"></td>
			</tr>
		</table>
	<input type="submit" value="회원가입">&nbsp;&nbsp;&nbsp;
	<input type="reset" value="취소">
	</fieldset>
</form>

</div>
</body>
</html>