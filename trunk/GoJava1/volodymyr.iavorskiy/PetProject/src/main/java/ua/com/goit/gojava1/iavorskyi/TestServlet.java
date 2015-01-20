package ua.com.goit.gojava1.iavorskyi;
import javax.servlet.http.*;
import javax.servlet.*;

import java.io.*;

public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private String name = null;
	private String password = null;
	
	public void init() {
		}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		name = req.getParameter("name");
		password = req.getParameter("password");
		PrintWriter out = resp.getWriter();
		out.println("<h1>" + name + " " + password + "</h1>");
//		resp.sendRedirect("index.html");
//		super.doGet(req, resp);
	}
	
//	public void service(ServletRequest request, ServletResponse response)
//			throws ServletException, IOException {
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<h1>" + message + "</h1>" + "count = " + count);
//		count++;
//		if (count > 5) {
//			count = 0;
//		}
//	}
	
	public void destroy() {
		
	}

}
