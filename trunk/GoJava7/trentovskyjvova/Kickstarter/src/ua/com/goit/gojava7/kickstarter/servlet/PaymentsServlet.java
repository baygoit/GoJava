package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.config.DataSourceTypes;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

@WebServlet("/payments")
public class PaymentsServlet extends HttpServlet {
	private DaoProvider daoProvider;
	private ProjectDao projectDao;
	private RewardDao rewardDao;

	@Override
	public void init() throws ServletException {
		daoProvider = new DaoProvider(DataSourceTypes.POSTGRES);
		daoProvider.init();
		projectDao = daoProvider.getProjectReader();
		rewardDao = daoProvider.getRewardsReader();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int projectId = Integer.parseInt(request.getParameter("projectId"));

		StringBuilder stringBuilder = new StringBuilder("<html><head><title>Payments</title></head><body>");

		for (Reward reward : rewardDao.getRewards(projectId)) {
			stringBuilder.append("<a href=\"pledge?rewardId=").append(reward.getId());
			stringBuilder.append("&projectId=").append(projectId).append("\">");

			stringBuilder.append("Pledge $").append(reward.getPledge()).append(" - get ").append(reward.getBenefit())
					.append("</a><br/>");

		}
		stringBuilder.append("<a href=\"pledge?rewardId=0").append("&projectId=").append(projectId);
		stringBuilder.append("\">").append("own amount\n").append("</a><br/>");
		stringBuilder.append("</body></html>");

		response.getWriter().append(stringBuilder.toString());
	}

}
