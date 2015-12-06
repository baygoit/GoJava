package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.config.DataSourceTypes;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.domain.Payment;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

@WebServlet("/pledge")
public class PledgeServlet extends HttpServlet {
	private DaoProvider daoProvider;
	private PaymentDao paymentDao;
	private RewardDao rewardDao;
	
	@Override
	public void init() throws ServletException {
		daoProvider = new DaoProvider(DataSourceTypes.POSTGRES);
		daoProvider.init();
		paymentDao = daoProvider.getPaymentReader();
		rewardDao = daoProvider.getRewardsReader();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int rewardId = Integer.parseInt(request.getParameter("rewardId"));
		int projectId = Integer.parseInt(request.getParameter("projectId"));

		StringBuilder stringBuilder = new StringBuilder("<html><head><title>Pledge</title></head><body>");
		stringBuilder.append("<form action=\"pledge?rewardId=").append(rewardId).append("&projectId=").append(projectId);

		stringBuilder.append("\" method=\"post\">");

		stringBuilder.append("<input type=\"text\" name=\"name\" placeholder=\"name\">").append("</br>");
		stringBuilder.append("<input type=\"text\" name=\"cardNumber\" placeholder=\"card number\">").append("</br>");
		if (rewardId == 0) {
			stringBuilder.append("<input type=\"text\" name=\"amount\" placeholder=\"amount\">").append("</br>");
		}
		stringBuilder.append("<input type=\"submit\" value=\"donate\">");
		stringBuilder.append("</form>");
		stringBuilder.append("</body></html>");

		response.getWriter().append(stringBuilder.toString());
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
