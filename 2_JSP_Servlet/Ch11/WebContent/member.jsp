<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="com.member.*"%>
<%@ page import="java.util.List"%>
<%
	MemberDAO dao = MemberDAO.getInstance();
	int r = dao.insertMember(new MemberDTO(
			request.getParameter("id"),
			request.getParameter("pw"),
			request.getParameter("name"),
			request.getParameter("email"),
			request.getParameter("address")));
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
		<style>
			#table, td, th, tr {
			border: solid 1px #000}
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
	if (r==dao.MEMBER_JOIN_SUCCESS&&request.getParameter("id")!=null) {
		List<MemberDTO> list = dao.listMember();
		for (int i=0; i<list.size(); i++) {
			MemberDTO m=list.get(i);
%>
			<tr>
				<td><%=m.getId()%></td>
				<td><%=m.getPw()%></td>
				<td><%=m.getName()%></td>
				<td><%=m.getEmail()%></td>
				<td><%=m.getAddress()%></td>
				<td><%=m.getRdate()%></td>
			</tr>
<%		
		}
	}
%>

		</table><br>
		<a href="/Ch11/join0.jsp">ȸ������ ���ư���</a>	
	</body>
</html>