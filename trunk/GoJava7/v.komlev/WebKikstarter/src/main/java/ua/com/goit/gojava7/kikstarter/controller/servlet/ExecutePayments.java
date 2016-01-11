package ua.com.goit.gojava7.kikstarter.controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kikstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kikstarter.dao.RewardDao;
import ua.com.goit.gojava7.kikstarter.domain.Payment;
import ua.com.goit.gojava7.kikstarter.domain.Reward;

@WebServlet("/payment")
public class ExecutePayments extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private int projectId;
	private String userName;
	private long numberCard;
	private int amountDonation;

	@Autowired
	private PaymentDao paymentDao;

	@Autowired
	private RewardDao rewardDao;

	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		projectId = Integer.parseInt(request.getParameter("id"));

		List<Reward> projectRewards = rewardDao.getProjectRewards(projectId);

		request.setAttribute("projectRewards", projectRewards);
		request.getRequestDispatcher("WEB-INF/jsp/payment_execute.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		userName = request.getParameter("firstName");
		numberCard = Long.parseLong(request.getParameter("cardNumber"));
		amountDonation = Integer.parseInt(request.getParameter("donatingSum"));

		Payment payment = new Payment();
		payment.setProjectId(projectId);
		payment.setUserName(userName);
		payment.setNumberCard(numberCard);
		payment.setAmountDonation(amountDonation);
		paymentDao.add(payment);

		response.sendRedirect("/webkikstarter/project?id=" + projectId);

	}

}
