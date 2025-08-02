package attributes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/GetAttribute")
public class GetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		out.print(request.getRequestURI()+"<br>");
		out.print("attr1 : "+context.getAttribute("attr1")+"<br>");
		out.print("attr2 : "+session.getAttribute("attr2")+"<br>");
		out.print("attr3 : "+request.getAttribute("attr3")+"<br>");
	}
}
