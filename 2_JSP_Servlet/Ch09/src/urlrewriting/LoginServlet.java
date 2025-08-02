package urlrewriting;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ls")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print(
				"안녕하세요!<br> 로그인하셨습니다.<br><br>"+
				"<html><body>"+
				"아이디   : " + request.getParameter("user_id")+ "<br>" +
				"비밀번호 : " + request.getParameter("user_pw")+ "<br>" +
				"주소     : " + request.getParameter("user_address")+ "<br>" +
				"휴대전화 : " + request.getParameter("user_hp")+ "<br>");
		String user_address = URLEncoder.encode(request.getParameter("user_address"), "utf-8");
		out.print(
				"<a href='http://192.168.0.29:8181/Ch09/lss?"+
				"user_id="+request.getParameter("user_id")+
				"&user_pw="+request.getParameter("user_pw")+
				"&user_address="+user_address+
				"'>두번째 서블릿으로 보내기</a></body></html>");
	}

}
