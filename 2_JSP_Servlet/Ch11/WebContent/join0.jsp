<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>Insert title here</title>
<style>
	#reg {
	text-align:center;
	border: 20px #000;
	font-size: 20px;}
	
</style>
</head>
<body>
<div id = "reg">
<h3>회원 가입 창</h3>
<form action="/Ch11/member2.jsp">
	<fieldset>
	아이디        : <input type="text" name="id" size="20"><br><br>
	비밀번호      : <input type="password" name="pw" size="20"><br/><br>
	비밀번호 확인 : <input type="password" name="pw_check" size="20"><br/><br>
	이름          : <input type="text" name="name" size="20"><br/><br>
	메일          : <input type="text" name="email" size="20"><br/><br>
	주소          : <input type="text" name="address" size="20"><br/><br>
	<input type="submit" value="회원가입">&nbsp;&nbsp;&nbsp;
	<input type="reset" value="취소">
	</fieldset>
</form>

</div>
</body>
</html>