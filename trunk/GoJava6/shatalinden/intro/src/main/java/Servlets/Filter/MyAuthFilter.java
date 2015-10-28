package Servlets.Filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class MyAuthFilter implements Filter{

	public void init(FilterConfig arg0) throws ServletException {}
	
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		PrintWriter out=resp.getWriter();
		
		String password=req.getParameter("password");
		if(password.equals("admin")){
		chain.doFilter(req, resp);//sends request to next resource
		}
		else{
		out.print("username or password error!");
		}
		
	}
	public void destroy() {}

	

}
