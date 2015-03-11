package ua.com.goit.gojava2.solo307.interview;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Composer")
public class Composer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		response.setContentType("text/html;charset=utf-8");
		String[] categories = request.getParameterValues("category");
		long start = System.currentTimeMillis();
		Interview.persistTime(start);
		request.setAttribute("category", categories);
		request.getRequestDispatcher("interview.jsp").forward(request, response);
	}
}
