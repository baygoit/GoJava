package site;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOQuote;

import java.io.IOException;

public class FirstPage extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		DAOQuote baseOfQuotes = new DAOQuote();
		String quote = baseOfQuotes.showQuote();

		req.setAttribute("quote", quote);
		req.getRequestDispatcher("Quote.jsp").forward(req, resp);

	}

}