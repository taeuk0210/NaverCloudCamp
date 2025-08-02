package jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/AppServlet")
public class AppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		ServletContext application = request.getServletContext();
		session.setAttribute("valueInSession", "binding session");
		application.setAttribute("valueInApp", "binding application");
		
		out.print(
				"<html>" + 
				"<head>" + 
				"<meta charset=\"EUC-KR\">" + 
				"<title>Insert title here</title>" + 
				"</head>" + 
				"<body>" + 
				"<a href='application1.jsp'>application1.jsp</a>" + 
				"</body>" + 
				"</html>");
	}

}
