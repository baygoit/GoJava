package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.dao.DaoFactory;
import ua.com.goit.gojava7.kickstarter.dao.MyDataSource;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;

import ua.com.goit.gojava7.kickstarter.domain.Reward;

@WebServlet("/rewards")
public class RewardsServlet extends HttpServlet {
	DaoFactory daoFactory;
	RewardDao rewardDao;
	ProjectDao projectDao;

	@Override
	public void init() {
		daoFactory = new DaoFactory(MyDataSource.DB);
		rewardDao = daoFactory.getRewardDAO();
		projectDao = daoFactory.getProjectDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StringBuilder stringBuilder = new StringBuilder("<html><head><title>Rewards</title></head><body>");
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		stringBuilder.append("<h1>" + projectDao.get(projectId).getName() + "</h1>");
		stringBuilder.append("<h3>Let's choose your reward!</h3>");

		List<Reward> rewards = new ArrayList<>();
		rewards = rewardDao.getByProject(projectId);

		stringBuilder.append(
				"<br/></br><a href=\"payment?id=" + 0 + "\">" + "No thanks, I just want to help the project." + "</a>");

		for (Reward reward : rewards) {
			stringBuilder.append(
					"<br/></br><a href=\"payment?id=" + reward.getId() + "\">" + "$" + reward.getAmount() + "</a>");
			stringBuilder.append("</br>" + reward.getReward());
		}
		
		stringBuilder.append("</body></html>");
		response.getWriter().append(stringBuilder);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
