<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" isELIgnored="false"%>
 <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
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
		margin:auto;
	}
	td {
		background-color: white;
	}
</style>
</head>
<body>
	<c:set var="id" value="hong" scope="page"/>
	<c:set var="pw" value="1234!" scope="page"/>
	<c:set var="name" value='${"ȫ�浿"}' scope="page"/>
	<c:set var="email" value='${"hong@nvaer.com"}' scope="page"/>
	<c:set var="address" value='${"����� ������" }' scope="page"/>
	<table>
		<tr>
			<th>���̵�</th>
			<th>��й�ȣ</th>
			<th>�̸�</th>
			<th>����</th>
			<th>�ּ�</th>
		</tr>
		<tr>
			<td>${id }</td>
			<td>${pw }</td>
			<td>${name }</td>
			<td>${email }</td>
			<td>${address}</td>
		</tr>
		<tr>
			<td><c:out value="&lt;" escapeXml="false"/></td>
		</tr>
		
	</table>
	
	
</body>
</html>