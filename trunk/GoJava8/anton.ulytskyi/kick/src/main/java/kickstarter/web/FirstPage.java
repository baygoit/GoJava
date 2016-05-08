package kickstarter.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import kickstarter.manager.Manager;

public class FirstPage extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Manager operator = new Manager();
		String quote = operator.getRandomQuote();

		req.setAttribute("quote", quote);
		req.getRequestDispatcher("Quote.jsp").forward(req, resp);

	}

}