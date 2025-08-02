<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.member.*"%>
<%@ page import="java.util.List"%>

<jsp:useBean id="member" class="com.member.MemberDTO" scope="page"/>
<jsp:setProperty name="member" property="*"/>

<%
	int r = MemberDAO.getInstance().insertMember(member);
	List<MemberDTO> list = MemberDAO.getInstance().listMember();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
		<style>
			#table, td, th, tr {
				text-align:center;
				border: solid 1px #000;
				width:"200";
			}
			th {
				background-color: skyblue;
			}
		</style>
	</head>
	<body>
		<table id="table">
			<tr>
			<th>���̵�</th>
			<th>��й�ȣ</th>
			<th>�̸�</th>
			<th>�̸���</th>
			<th>�ּ�</th>
			<th>���Գ�¥</th>
			</tr>
<%
		for (int i=0; i<list.size(); i++) {
			MemberDTO m=list.get(i);
%>
			<tr>
				<td><%=m.getId() %></td>
				<td><%=m.getPw()%></td>
				<td><%=m.getName()%></td>
				<td><%=m.getEmail()%></td>
				<td><%=m.getAddress()%></td>
				<td><%=m.getRdate()%></td>
			</tr>
<%		
		}
%>
		</table><br>
		<a href="/Ch11/join0.jsp">ȸ������ ���ư���</a>	
	</body>
</html>