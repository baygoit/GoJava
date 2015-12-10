package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.domain.Payment;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

@WebServlet("/pledge")
public class PledgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PaymentDao paymentDao;
	private RewardDao rewardDao;
	
	private DaoProvider daoProvider;
	protected WebApplicationContext applicationContext;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext servletContext = config.getServletContext();
		applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);

		daoProvider = applicationContext.getBean(DaoProvider.class);
		//daoProvider.open();
		super.init(config);
	}
	
	@Override
	public void init() throws ServletException {
		paymentDao = daoProvider.getPaymentReader();
		rewardDao = daoProvider.getRewardsReader();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int rewardId = Integer.parseInt(request.getParameter("rewardId"));
		int projectId = Integer.parseInt(request.getParameter("projectId"));

		request.setAttribute("rewardId", rewardId);
		request.setAttribute("projectId", projectId);
		request.getRequestDispatcher("/WEB-INF/jsp/pledge.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int rewardId = Integer.parseInt(request.getParameter("rewardId"));
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		int donate = 0;
				
		String name = request.getParameter("name");
		String cardNumber = request.getParameter("cardNumber");

		Payment payment = new Payment();

		payment.setProjectId(projectId);
		payment.setName(name);
		payment.setCardNumber(cardNumber);
		if (rewardId == 0) {
			donate = Integer.parseInt(request.getParameter("amount"));
		} else {
			Reward reward = rewardDao.getReward(rewardId);
			donate = reward.getPledge();
		}
		payment.setPledge(donate);

		paymentDao.addPayment(payment);

		response.sendRedirect("project?projectId=" + projectId); 

	}

}
