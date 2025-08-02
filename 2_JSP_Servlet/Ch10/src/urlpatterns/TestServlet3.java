package urlpatterns;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.do")
public class TestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print(
				"<html><head><title>Test Servlet</title></head><body bgcolor='yellow'>" + 
				"Context Path : " + request.getContextPath() + "<br>" +
				"URL : " + request.getRequestURL() + "<br>" + 
				"URI : " + request.getRequestURI() + "<br>" + 
				"mapping : " + request.getServletPath() + "<br>" + 
				"</body></html>");		
	}

}
