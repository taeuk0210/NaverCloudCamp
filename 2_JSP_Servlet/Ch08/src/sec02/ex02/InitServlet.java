package sec02.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
		description = "initialization of servlet practice", 
		urlPatterns = { 
				"/init1", 
				"/init2"
		}, 
		initParams = { 
				@WebInitParam(name = "name", value = "kang"), 
				@WebInitParam(name = "email", value = "rkd7198@bnaver.com")
		})
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletConfig config = getServletConfig();
		out.print("<html><body>name="+config.getInitParameter("name")+
				"<br>email="+config.getInitParameter("email")+"</body></html>");
	}

}
