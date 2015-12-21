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

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ua.com.goit.gojava7.kickstarter.DAO.dbStorage.mysql.PaymentDbStorage;
import ua.com.goit.gojava7.kickstarter.DAO.dbStorage.mysql.ProjectDbStorage;
import ua.com.goit.gojava7.kickstarter.DAO.dbStorage.mysql.QuestionDbStorage;
import ua.com.goit.gojava7.kickstarter.model.Payment;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Question;

@WebServlet("/project")
public class ProjectInfoPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProjectDbStorage projectStorage;
	PaymentDbStorage paymentStorage;
	QuestionDbStorage questionStorage;
       
	@Override
	public void init() throws ServletException {
//		Initializator initializator = (Initializator) this.getServletContext().getAttribute(ContextListener.INITIALIZATOR);
//		projectStorage = initializator.getProjectStorage();
//		paymentStorage = initializator.getPaymentStorage();
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		projectStorage = webApplicationContext.getBean("projectDbStorage", ProjectDbStorage.class);
		paymentStorage = webApplicationContext.getBean("paymentDbStorage", PaymentDbStorage.class);
		questionStorage = webApplicationContext.getBean("questionDbStorage", QuestionDbStorage.class);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int projectId = Integer.parseInt(request.getParameter("id"));
		Project project = projectStorage.getProjectById(projectId);
		List<Question> questions = new ArrayList<>();
		questions = questionStorage.getQuestionsFromSelectedCategory(projectId);

		request.setAttribute("project", project);
		request.setAttribute("payment", paymentStorage.getSummaryProjectCostsCollected(projectId));
		request.setAttribute("questions", questions);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/project.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
		}
	}

}
