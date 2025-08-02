package attributes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SetAttribute")
public class SetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		HttpSession session = request.getSession();
		
		context.setAttribute("attr1", "context binding");
		session.setAttribute("attr2", "session binding");
		request.setAttribute("attr3", "request binding");
		RequestDispatcher dis = request.getRequestDispatcher("/GetAttribute");
		dis.forward(request, response);
	}
}
