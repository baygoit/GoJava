package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.beans.Reward;
import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.config.DataSource;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;

/**
 * Servlet implementation class Payment
 */
@WebServlet("/payment")
public class ExecutePayment extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private int projectId;
	
	private long creditCardNumber;
	private String userName;
	private int donatingSum;
	
	private PaymentDao paymentDao;
	private RewardDao rewardDao;
	private DaoProvider daoProvider;
       
	public void init(ServletConfig config) throws ServletException {
		
		daoProvider = new DaoProvider(DataSource.MYSQL);
		daoProvider.open();
		
		paymentDao = daoProvider.getPaymentDao();
		rewardDao = daoProvider.getRewardDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		projectId = Integer.parseInt(request.getParameter("id"));
		
		List<Reward> projectRewards = rewardDao.getProjectsRewards(projectId);
		
		HttpSession session = request.getSession();
		session.setAttribute("projectRewards", projectRewards);
		
		request.getRequestDispatcher("WEB-INF/views/execute_payment.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("errors", false);
		
		validateUserName(request, response);
		
		validateCreditCardNumber(request, response);
		
		validateDonatingSum(request, response);
	
		Payment payment = new Payment();
		payment.setProjectID(projectId);
		payment.setUserName(userName);
		payment.setCreditCardNumber(creditCardNumber);
		payment.setDonatingSum(donatingSum);
		
		paymentDao.add(payment);
		
		if ((Boolean)request.getAttribute("errors")) {
			
			request.getRequestDispatcher("WEB-INF/views/execute_payment.jsp").forward(request, response);
			
		}
		
		response.sendRedirect("/mykickstarter/project?id=" + projectId);
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
}
