package member4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ms4")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}		

	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		MemberDAO md = new MemberDAO();
		String command = request.getParameter("command");
		RequestDispatcher dispatch = request.getRequestDispatcher("/mv");
		
		if (command!=null && command.equals("add")) {
			MemberVO vo = new MemberVO();
			vo.setId(request.getParameter("id"));
			vo.setPw(request.getParameter("pw"));
			vo.setName(request.getParameter("name"));
			vo.setEmail(request.getParameter("email"));
			md.addMember(vo);
		} else if (command!=null && command.equals("del")) {
			md.delMember(request.getParameter("id"));
		}
		
		List<MemberVO> list = md.listMembers();
		request.setAttribute("memberList", list);
		dispatch.forward(request, response);
		
	}


}
