<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" isELIgnored="false"%>
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
	<table>
		<tr>
			<th>���̵�</th>
			<th>��й�ȣ</th>
			<th>�̸�</th>
			<th>����</th>
			<th>�ּ�</th>
		</tr>
		<tr>
			<td>${param.id }</td>
			<td>${param.pw }</td>
			<td>${param.name }</td>
			<td>${param.email }</td>
			<td>${requestScope.address}</td>
		</tr>
	</table>
	
	
</body>
</html>