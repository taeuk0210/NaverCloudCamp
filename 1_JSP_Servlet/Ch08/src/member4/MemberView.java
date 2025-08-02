package member4;

import java.util.List;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mv")
public class MemberView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		List<MemberVO> list = (List<MemberVO>) request.getAttribute("memberList");		
		
		out.print("<html><body><table border=1><tr align=center bgcolor=skyblue>"+
				  "<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td>");
		list.stream().forEach(vo -> {
			out.print("<tr><td>"+vo.getId()+"</td>"+
					  "<td>"+vo.getPw()+"</td>"+
					  "<td>"+vo.getName()+"</td>"+
					  "<td>"+vo.getEmail()+"</td>"+
					  "<td>"+vo.getDate()+"</td>"+
					  "<td><a href=http://192.168.0.29:8181/Ch08/ms4?command=del&id="+vo.getId()+">삭제</a></td></tr>");
		});
		out.print("</table>");
		out.print("<a href='http://192.168.0.29:8181/Ch08/Member4Form.html'>회원등록</a>");
		out.print("</body></html>");
	}

}
