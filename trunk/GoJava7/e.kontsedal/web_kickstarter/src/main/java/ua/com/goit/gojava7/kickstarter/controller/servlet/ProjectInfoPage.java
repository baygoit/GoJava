package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.DAO.AbstractPaymentStorage;
import ua.com.goit.gojava7.kickstarter.DAO.AbstractProjectStorage;
import ua.com.goit.gojava7.kickstarter.controller.Initializator;
import ua.com.goit.gojava7.kickstarter.controller.servlet.util.ContextListener;
import ua.com.goit.gojava7.kickstarter.model.Payment;
import ua.com.goit.gojava7.kickstarter.model.Project;

@WebServlet("/project")
public class ProjectInfoPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AbstractProjectStorage projectStorage;
	AbstractPaymentStorage paymentStorage;
       
	@Override
	public void init() throws ServletException {
		Initializator initializator = (Initializator) this.getServletContext().getAttribute(ContextListener.INITIALIZATOR);
		projectStorage = initializator.getProjectStorage();
		paymentStorage = initializator.getPaymentStorage();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int projectId = Integer.parseInt(request.getParameter("id"));
		Project project = projectStorage.getProjectById(projectId);
		
		request.setAttribute("project", project);
		request.setAttribute("payment", paymentStorage.getSummaryProjectCostsCollected(projectId));
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/project.jsp");
		view.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		int projectId = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("inputName");
		Long cardNumber = Long.parseLong(request.getParameter("inputCardNumber"));
		int amount = Integer.parseInt(request.getParameter("inlineRadioOptions"));
		
		if (name != null && !name.isEmpty() && cardNumber != null && amount == 0) {
			amount = Integer.parseInt(request.getParameter("amount"));
		}
		if (name != null && !name.isEmpty() && cardNumber != null && amount > 0) {
			Payment payment = new Payment();
			payment.setIdParentProject(projectId);
			payment.setCardOwner(name);
			payment.setCardNumber(cardNumber);
			payment.setRechargeAmount(amount);
			paymentStorage.add(payment);
			response.sendRedirect("./project?id=" + projectId);
		}
		System.out.println(name);
		System.out.println(cardNumber);
		System.out.println(amount);
	}

}
