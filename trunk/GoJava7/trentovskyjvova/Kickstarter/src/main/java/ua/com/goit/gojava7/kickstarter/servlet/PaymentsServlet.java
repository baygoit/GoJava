package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;
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

import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

@WebServlet("/payments")
public class PaymentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PaymentsServlet.class);
	
	@Autowired
	private RewardDao rewardDao;
	
	@Override
	public void init() throws ServletException {
		log.info("Starting Spring autowiring...");
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		log.info("Ended Spring autowiring...");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("doGet");
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		log.debug("projectId: " + projectId);
		
		List<Reward> rewards = rewardDao.getRewards(projectId);
		log.debug("Rewards: " + rewards);
		
		request.setAttribute("rewards", rewards);
		request.setAttribute("projectId", projectId);
		request.getRequestDispatcher("/WEB-INF/jsp/payments.jsp").forward(request, response);
		log.info("Ended doGet");
	}

}
