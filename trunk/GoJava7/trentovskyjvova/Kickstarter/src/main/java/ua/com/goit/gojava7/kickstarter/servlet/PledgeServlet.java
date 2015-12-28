package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.domain.Payment;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

@WebServlet("/pledge")
public class PledgeServlet extends HttpServlet {
	private static final String PATH_PLEDGE_JSP = "/WEB-INF/jsp/pledge.jsp";
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PledgeServlet.class);
	
	@Autowired
	private PaymentDao paymentDao;
	@Autowired
	private RewardDao rewardDao;
	@Autowired
	protected RequestValidation requestValidation;

	@Override
	public void init() throws ServletException {
		log.info("Starting Spring autowiring...");
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		log.info("Ended Spring autowiring...");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("doGet");
		int rewardId = Integer.parseInt(request.getParameter("rewardId"));
		log.debug("rewardId: {}", rewardId);
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		log.debug("projectId: {}", projectId);

		request.setAttribute("rewardId", rewardId);
		request.setAttribute("projectId", projectId);
		request.getRequestDispatcher(PATH_PLEDGE_JSP).forward(request, response);
		log.info("Ended doGet");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("doPost");
		int rewardId = Integer.parseInt(request.getParameter("rewardId"));
		log.debug("rewardId: {}", rewardId);
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		log.debug("projectId: {}", projectId);
		int donate = 0;

		request.setAttribute("errors", false);
		List<String> emptyCheckParameters = new ArrayList<>(Arrays.asList("name", "cardNumber"));
		List<String> naturalCheckParameters = new ArrayList<>();
		if (rewardId == 0) {
			naturalCheckParameters.add("amount");
		}
		if (requestValidation.isEmpty(request, emptyCheckParameters)
				|| requestValidation.isNatural(request, naturalCheckParameters)) {
			doGet(request, response);
		} else {

			if (rewardId == 0) {
				donate = Integer.parseInt(request.getParameter("amount"));
			} else {
				Reward reward = rewardDao.getReward(rewardId);
				donate = reward.getPledge();
			}
			log.debug("doPost() donate: {}", donate);
			
			String name = request.getParameter("name");
			log.debug("doPost() name: {}", name);
			String cardNumber = request.getParameter("cardNumber");
			log.debug("doPost() cardNumber: {}", cardNumber);
			
			Payment payment = new Payment();

			payment.setProjectId(projectId);
			payment.setName(name);
			payment.setCardNumber(cardNumber);
			payment.setPledge(donate);
			log.info("new Payment {}", payment);
			
			paymentDao.addPayment(payment);

			response.sendRedirect("project?projectId=" + projectId);
		}
		log.info("Ended doPost");
	}

}
