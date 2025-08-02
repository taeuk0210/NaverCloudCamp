package member2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ms2")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberDAO md = new MemberDAO();
		List<MemberVO> list = md.listMembers();
		
		out.print("<html><body><table border=1><tr align=center bgcolor=lightgreen>"+
				  "<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td>");
		list.stream().forEach(vo -> {
			out.print("<tr><td>"+vo.getId()+"</td>"+
					  "<td>"+vo.getPw()+"</td>"+
					  "<td>"+vo.getName()+"</td>"+
					  "<td>"+vo.getEmail()+"</td>"+
					  "<td>"+vo.getDate()+"</td>");
		});
		out.print("</body></html>");
	}


}
