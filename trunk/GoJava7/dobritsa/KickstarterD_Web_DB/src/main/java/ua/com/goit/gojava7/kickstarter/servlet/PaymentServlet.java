package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;
import java.util.ArrayList;
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

import ua.com.goit.gojava7.kickstarter.config.Validator;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.models.Category;
import ua.com.goit.gojava7.kickstarter.models.Project;
import ua.com.goit.gojava7.kickstarter.models.Reward;

@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PaymentServlet.class);

	@Autowired
	private ProjectDao projectDao;

	@Autowired
	private RewardDao rewardDao;

	@Autowired
	private Validator validator;

	private HttpServletRequest request;
	private HttpServletResponse response;

	private Long amount;
	private Project project;
	private Category category;
	private List<Reward> rewards = new ArrayList<>();

	@Override
	public void init() {
		log.info("Starting spring autowiring...");
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		log.info("Ended spring autowiring...");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		log.info("doGet()...");

		this.request = request;
		this.response = response;

		if (rewardExists()) {
			payWithReward();
			return;
		}

		payWithoutReward();
	}

	public boolean rewardExists() {
		Long rewardId = Long.parseLong(request.getParameter("id"));
		return rewardId != 0;
	}

	public void payWithReward() throws ServletException, IOException {
		Long rewardId = Long.parseLong(request.getParameter("id"));
		Reward reward = rewardDao.get(rewardId);
		amount = reward.getAmount();
		project = reward.getProject();
		category = project.getCategory();

		forwardRequestWithCorrectAmount();
	}

	public void forwardRequestWithCorrectAmount() throws ServletException, IOException {
		request.setAttribute("category", category);
		request.setAttribute("project", project);
		request.setAttribute("amount", amount);

		request.getRequestDispatcher("/WEB-INF/jsp/payment.jsp").forward(request, response);
	}

	public void payWithoutReward() throws ServletException, IOException {
		Long projectId = Long.parseLong(request.getParameter("projectId"));
		project = projectDao.get(projectId);
		category = project.getCategory();

		if (amountIsValid()) {
			amount = Long.parseLong(request.getParameter("amount"));
			forwardRequestWithCorrectAmount();
			return;
		}

		rewards = rewardDao.getByProject(projectId);
		forwardRequestWrongAmount();
	}

	public boolean amountIsValid() {
		return validator.validateAmountOfPledge(request.getParameter("amount"));
	}

	public void forwardRequestWrongAmount() throws ServletException, IOException {
		request.setAttribute("category", category);
		request.setAttribute("project", project);
		request.setAttribute("rewards", rewards);
		request.setAttribute("message", "-----Wrong amount-----");

		request.getRequestDispatcher("/WEB-INF/jsp/rewards.jsp").forward(request, response);
	}
}
