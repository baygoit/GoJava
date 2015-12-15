package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.DAO.AbstractCategoryStorage;
import ua.com.goit.gojava7.kickstarter.DAO.AbstractPaymentStorage;
import ua.com.goit.gojava7.kickstarter.DAO.AbstractProjectStorage;
import ua.com.goit.gojava7.kickstarter.controller.Initializator;
import ua.com.goit.gojava7.kickstarter.controller.servlet.util.ContextListener;
import ua.com.goit.gojava7.kickstarter.model.Project;

@WebServlet("/category")

public class CategoryPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AbstractProjectStorage projectStorage;
	AbstractPaymentStorage paymentStorage;
	AbstractCategoryStorage categoryStorage;
       
    @Override
    public void init() throws ServletException {
    	Initializator initializator = (Initializator) this.getServletContext().getAttribute(ContextListener.INITIALIZATOR);
    	projectStorage = initializator.getProjectStorage();
    	paymentStorage = initializator.getPaymentStorage();
    	categoryStorage = initializator.getCategoryStorage();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		List<Project> projects = projectStorage.getProjectsFromSelectedCategory(categoryId);
		request.setAttribute("projects", projects);
		request.setAttribute("payments", paymentStorage);
		request.setAttribute("categoryName", categoryStorage.getCategoryById(categoryId).getCategoryName());
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/category.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
