package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.beans.Reward;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;

@WebServlet("/payment")
public class ExecutePayment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int projectId;
	private long creditCardNumber;
	private String userName;
	private int donatingSum;

	@Autowired
	private PaymentDao paymentDao;

	@Autowired
	private RewardDao rewardDao;

	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		projectId = Integer.parseInt(request.getParameter("id"));

		List<Reward> projectRewards = rewardDao.getProjectsRewards(projectId);

		request.setAttribute("projectRewards", projectRewards);
		request.getRequestDispatcher("WEB-INF/views/execute_payment.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("errors", false);

		validateUserName(request, response);
		validateCreditCardNumber(request, response);
		validateDonatingSum(request, response);

		if ((Boolean) request.getAttribute("errors")) {
			request.getRequestDispatcher("WEB-INF/views/execute_payment.jsp").forward(request, response);
		} else {
			saveCreatedPayment();

			response.sendRedirect("/kickstarter/project?id=" + projectId);
		}
	}

	protected void validateUserName(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("first-name");

		if (userName.isEmpty()) {
			request.setAttribute("errors", true);
			request.setAttribute("nameError", true);
		}
	}

	protected void validateCreditCardNumber(HttpServletRequest request, HttpServletResponse response) {
		String regex = "\\d{13,16}";
		Pattern pattern = Pattern.compile(regex);

		if (request.getParameter("creditCardNumber").isEmpty()) {

			request.setAttribute("errors", true);
			request.setAttribute("creditCardError", true);

		} else {

			try {

				creditCardNumber = Long.parseLong(request.getParameter("creditCardNumber"));

			} catch (NumberFormatException e) {

				request.setAttribute("errors", true);
				request.setAttribute("creditCardError", true);
			}

			Matcher matcher = pattern.matcher(Long.toString(creditCardNumber));
			if (matcher.matches() == false) {
				request.setAttribute("errors", true);
				request.setAttribute("creditCardError", true);
			}
		}
	}

	protected void validateDonatingSum(HttpServletRequest request, HttpServletResponse response) {
		if (request.getParameter("donatingSum").isEmpty()) {

			request.setAttribute("errors", true);
			request.setAttribute("donatingSumError", true);

		} else {

			try {

				donatingSum = Integer.parseInt(request.getParameter("donatingSum"));

			} catch (NumberFormatException e) {

				request.setAttribute("errors", true);
				request.setAttribute("donatingSumError", true);
			}
		}
	}

	protected void saveCreatedPayment() {
		Payment payment = new Payment();
		payment.setProjectID(projectId);
		payment.setUserName(userName);
		payment.setCreditCardNumber(creditCardNumber);
		payment.setDonatingSum(donatingSum);
		paymentDao.add(payment);
	}
}
