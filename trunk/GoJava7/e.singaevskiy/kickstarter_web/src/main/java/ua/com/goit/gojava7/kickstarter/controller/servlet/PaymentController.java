package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.dao.RewardDAO;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

@WebServlet("/payment")
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private RewardDAO rewardDAO;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Reward reward = rewardDAO.get(Integer.valueOf(request.getParameter("rewardId")));
		request.setAttribute("amount", reward.getPledgeSum());
		request.getRequestDispatcher("view/Payment.jsp").forward(request, response);
	}

	@Override
	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

}
