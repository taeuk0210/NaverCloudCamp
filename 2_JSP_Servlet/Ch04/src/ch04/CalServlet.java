package ch04;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/cs"})
public class CalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doPost()로 포워딩
		System.out.println("do call");
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1, num2, result;
		String op;
		
		// client 응답 시 전달될 컨텐츠에 대한 티입 설정과 캐릿터셋 설정
		response.setContentType("text/html;charset=UTF-8");
		
		// 클라이언트 응답을 위한 출력 스트림 확보
		PrintWriter out = response.getWriter();
		
		// HTML 폼을 통해 전달된 num1, num2 파라미터 값을 변수에 할당
		// 이때 getParameter() 는 문자열을 반환하므로 변환해줘야함
		num1 = Integer.parseInt(request.getParameter("num1"));
		num2 = Integer.parseInt(request.getParameter("num2"));
		op = request.getParameter("operator");
		// Calc() 호출로 결과를 받아옴 
		Calc calc = new Calc(num1, num2, op);
		result = calc.getResult();
		
		// 출력 스트림을 통해 화면 구성
		out.println("<HTML>");
		out.println("<HEAD><TITLE>계산기</TITLE></HEAD>");
		out.println("<BODY><center>");
		out.println("<H2>계산 결과</H2>");
		out.println("<HR>");
		out.println(num1 + " " + op + " " + num2 + " = " + result);
		out.println("메롱 ㅋㅋ");
		out.println("</BODY>");
		out.println("</HTML>");
		
		
	}

}
