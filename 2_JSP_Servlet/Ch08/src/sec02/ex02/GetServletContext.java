package sec02.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cget")
public class GetServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
		List<String> member = (List<String>) context.getAttribute("member");
		//out.print("<html><body>get "+ member.get(0) +" and "+ member.get(1) +"<br><table>"+
		out.print("<html><body>get<br><table>"+
		"<tr><td>"+ context.getInitParameter("menu_member") +"</td></tr>" + 
		"<tr><td>"+ context.getInitParameter("menu_order") +"</td></tr>" + 
		"<tr><td>"+ context.getInitParameter("menu_goods") +"</td></tr>" +		
		"</table></body></html>");
	}

}
