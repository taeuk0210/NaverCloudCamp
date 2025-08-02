import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lg5")
public class LoginServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init is called");
	}

	public void destroy() {
		System.out.println("destroy is called");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet is called");
		doHandle(request, response);
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost is called");
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		System.out.println("user id : " + user_id);
		System.out.println("user pw : " + user_pw);
		if (user_id!=null && user_id.length()!=0) {
			out.print("<html><body>"+ user_id + "님 로그인 하셨습니다.</body></html>");
		} else {
			out.print("<html><body> 아이디를 입력하세요 <br>"+
					  "<a href=http://192.168.0.29:8181/Ch06/login3.html>로그인 창으로 이동</a>"+
					  "</body></html>");
		}
	}
}