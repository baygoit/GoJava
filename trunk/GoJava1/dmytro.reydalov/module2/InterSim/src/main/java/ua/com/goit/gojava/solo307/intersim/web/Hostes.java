package ua.com.goit.gojava.solo307.intersim.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava.solo307.intersim.domain.Interview;;

@WebServlet("/Hostes")
public class Hostes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Hostes() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("fname");
        Interview interview = new Interview();
        interview.addName(name);
		request.getRequestDispatcher("menu.html").forward(request, response);
	}
}
