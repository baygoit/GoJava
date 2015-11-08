package Servlets.RequestDispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleLogin extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String n=request.getParameter("userName");
		String p=request.getParameter("userPass");

		if(p.equals("admin")){
			RequestDispatcher rd=request.getRequestDispatcher("welcomeServlet");
			rd.forward(request, response);
		}
		else{
			out.print("Sorry UserName or Password Error!");
			RequestDispatcher rd=request.getRequestDispatcher("/ServletApp/servlet_requestDispatcher.html");
			rd.include(request, response);

		}
	}

}
