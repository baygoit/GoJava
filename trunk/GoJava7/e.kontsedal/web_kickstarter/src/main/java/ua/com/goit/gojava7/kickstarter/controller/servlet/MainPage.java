package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.DAO.dbStorage.mysql.CategoryDbStorage;
import ua.com.goit.gojava7.kickstarter.DAO.dbStorage.mysql.QuoteDbStorage;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Quote;

@WebServlet("/main")

public class MainPage extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	QuoteDbStorage quoteStorage;
	@Autowired
	CategoryDbStorage categoryStorage;

	@Override
	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Quote randomQuote = quoteStorage.getRandomQuote();
		request.setAttribute("text", randomQuote.getText());
		request.setAttribute("author", randomQuote.getAuthor());
		
		List<Category> allCategories = new ArrayList<>();
		allCategories = categoryStorage.getAll();
		request.setAttribute("categories", allCategories);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
		view.forward(request, response);
		//response.sendRedirect("category?id=1");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
