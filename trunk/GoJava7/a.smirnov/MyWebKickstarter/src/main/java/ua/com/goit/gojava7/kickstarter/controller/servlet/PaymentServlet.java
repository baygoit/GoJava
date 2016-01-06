package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;

@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private PaymentDao paymentDao;

	@Autowired
	private RewardDao rewardDao;

	@Autowired
	private ProjectDao projectDao;

	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		String userName = request.getParameter("first-name");
		Long creditCardNumber = Long.parseLong(request.getParameter("creditCardNumber"));
		int pledge = Integer.parseInt(request.getParameter("donatingSum"));
		saveCreatedPayment(projectId, userName, creditCardNumber, pledge);

		response.sendRedirect("./project?id=" + projectId);
	}

	void saveCreatedPayment(int projectId, String userName, long creditCardNumber, int pledge) {
		Payment payment = new Payment();
		Project project = projectDao.getProjectById(projectId);

		payment.setProject(project);
		payment.setOwnerName(userName);
		payment.setCreditCardNumber(creditCardNumber);
		payment.setPledge(pledge);
		paymentDao.add(payment);
	}
}
