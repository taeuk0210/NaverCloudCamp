package filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/cl")
public class CallListener extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		LoginImpl loginUser = new LoginImpl(id, pw);
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		if (session.isNew()) {
			session.setAttribute("loginUser", loginUser);
		}

		out.print("<html><head>"+
				"<script type='text/javascript'>"+
				//"setTimeout('history.go(0);',1000)"+
				"</script></head><body>"+
				"아이디 :" + loginUser.id + "<br>" +
				"접속자 수 : "+LoginImpl.total  + "</body></html>");
		
	}
}
