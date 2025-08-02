package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class EncodeFilter implements Filter {

    public EncodeFilter() {
        System.out.println("call constructor");
    }

	public void destroy() {
		System.out.println("call destroy");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("call doFilter");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String context = ((HttpServletRequest)request).getContextPath();
		String pathinfo = ((HttpServletRequest)request).getRequestURI();
		String mesg = "context : " + context + "\nURI : " + pathinfo + "\n";
		System.out.println(mesg);
		
		long s = System.currentTimeMillis();
		chain.doFilter(request, response);
		long e = System.currentTimeMillis();
		System.out.println("working time : "+ (e-s) + "ms\n");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("call init");
	}

}
