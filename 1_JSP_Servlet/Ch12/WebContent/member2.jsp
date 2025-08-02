<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" isELIgnored="false" import="java.util.*, com.member.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	table, tr, th, td {
		text-align: center;
		background-color: skyblue;
		width 200;
		margin: auto;
	}
	td {
		background-color: white;
	}
</style>
</head>
<body>
	<jsp:useBean id="m1" class="com.member.MemberDTO"/>
	<jsp:setProperty property="*" name="m1"/>
	<jsp:useBean id="list" class="java.util.ArrayList"/>
	<% list.add(m1); %>
	
	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>메일</th>
			<th>주소</th>
		</tr>
		<tr>
			<td>${m.id }</td>
			<td>${list[0].pw }</td>
			<td>${list[0].name }</td>
			<td>${list[0].email }</td>
			<td>${requestScope.address}</td>
		</tr>
	</table>
	
	
</body>
</html>