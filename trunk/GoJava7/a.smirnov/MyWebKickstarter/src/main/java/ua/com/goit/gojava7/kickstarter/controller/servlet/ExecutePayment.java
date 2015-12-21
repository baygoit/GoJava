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

		String userName = validateUserName(request, response);
		long creditCardNumber = validateCreditCardNumber(request, response);
		int pledge = validateDonatingSum(request, response);

		if ((Boolean) request.getAttribute("errors")) {
			request.getRequestDispatcher("WEB-INF/views/execute_payment.jsp").forward(request, response);
		} else {
			saveCreatedPayment(userName, creditCardNumber, pledge);
			response.sendRedirect("/kickstarter/project?id=" + projectId);
		}
	}

	String validateUserName(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("first-name");

		if (userName.isEmpty()) {
			request.setAttribute("errors", true);
			request.setAttribute("nameError", true);
		}
		return userName;
	}

	long validateCreditCardNumber(HttpServletRequest request, HttpServletResponse response) {
		String userCreditCard = request.getParameter("creditCardNumber");
		long creditCardNumber = 0;

		if (userCreditCard.isEmpty()) {
			request.setAttribute("errors", true);
			request.setAttribute("creditCardError", true);
		} else {
			try {
				creditCardNumber = Long.parseLong(userCreditCard);
			} catch (NumberFormatException e) {
				request.setAttribute("errors", true);
				request.setAttribute("creditCardError", true);
			}

			String regex = "\\d{13,16}";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(userCreditCard);
			if (matcher.matches() == false) {
				request.setAttribute("errors", true);
				request.setAttribute("creditCardError", true);
			}
		}
		return creditCardNumber;
	}

	int validateDonatingSum(HttpServletRequest request, HttpServletResponse response) {
		String pledge = request.getParameter("donatingSum");
		int donatingSum = 0;

		if (pledge.isEmpty()) {
			request.setAttribute("errors", true);
			request.setAttribute("donatingSumError", true);
		} else {
			try {
				donatingSum = Integer.parseInt(pledge);
			} catch (NumberFormatException e) {
				request.setAttribute("errors", true);
				request.setAttribute("donatingSumError", true);
			}
		}
		return donatingSum;
	}

	void saveCreatedPayment(String userName, long creditCardNumber, int pledge) {
		Payment payment = new Payment();
		payment.setProjectID(projectId);
		payment.setUserName(userName);
		payment.setCreditCardNumber(creditCardNumber);
		payment.setDonatingSum(pledge);
		paymentDao.add(payment);
	}
}
