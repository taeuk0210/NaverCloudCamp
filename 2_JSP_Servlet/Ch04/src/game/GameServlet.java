package game;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/gs")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		TwoArray game = new TwoArray();
		Enumeration<String> enums = request.getParameterNames();
		List<String> names = new ArrayList<>();
		while (enums.hasMoreElements()) {
			names.add((String) enums.nextElement());
		}
		
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++) {
				game.map[i][j] = Integer.parseInt(request.getParameter("num"+(i+1)+(j+1)));
			}
		}
		
		if (request.getParameter("up")!=null) {
			game.moveTop(game);
		} else if (request.getParameter("down")!=null) {
			game.moveBottom(game);
		} else if (request.getParameter("left")!=null) {
			game.moveLeft(game);
		} else if (request.getParameter("right")!=null) {
			game.moveRight(game);
		}
		game.updateMap(3, game);
		
		String html = "<!DOCTYPE html>" + 
				"<html><head><meta charset=\"UTF-8\">" + 
				"<title> 2048 </title></head><body><CENTER>" + 
				"<H3>2048</H3><HR>" + 
				"<form action=http://localhost:8181/FirstJSP/gs method=post>";
		for (int i=1;i<5;i++) {
			for (int j=1;j<5;j++) {
				html += "<INPUT type=text name=num"+i+j+
						" width=200 size=3 value="+game.map[i-1][j-1]+
						" readonly>";
			}
			html += "<br>";
		}

		html += "<INPUT type=submit value=left name=left>" +
				"<INPUT type=submit value=up name=up>" + 
				"<INPUT type=submit value=down name=down>" + 
				"<INPUT type=submit value=right name=right>" + 
				"</CENTER></body>\r\n</html>";
		PrintWriter out = response.getWriter();
		out.println(html);
	}
}
