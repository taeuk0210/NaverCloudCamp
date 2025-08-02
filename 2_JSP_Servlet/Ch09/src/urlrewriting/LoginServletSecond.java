package urlrewriting;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lss")
public class LoginServletSecond extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		String address = request.getParameter("user_address");
		
		out.print("<html><body>");
		if (id!=null&&id.length()!=0) {
			out.print(
					"이미 로그인 상태입니다!<br><br>"+
					"넘겨받은 아이디   : "+id+"<br>"+
					"넘겨받은 비밀번호 : "+pw+"<br>"+
					"넘겨받은 주소     : "+address+"<br>"+
					"</body></html>");
		} else {
			out.print(
					"로그인 하지 않았습니다!<br><br>"+
					"다시 로그인하세요!<br>"+
					"<a href='http://192.168.0.29:8181/Ch09/ch09/login.html'>로그인창으로 이동하기</a>");
		}
	}
}
