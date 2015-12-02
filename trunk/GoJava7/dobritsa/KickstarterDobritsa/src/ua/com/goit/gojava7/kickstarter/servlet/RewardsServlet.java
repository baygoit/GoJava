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
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;

import ua.com.goit.gojava7.kickstarter.domain.Reward;

@WebServlet("/rewards")
public class RewardsServlet extends HttpServlet {
	DaoFactory daoFactory;
	RewardDao rewardDao;
	
	@Override
	public void init() {
		daoFactory = new DaoFactory(MyDataSource.DB);
		rewardDao = daoFactory.getRewardDAO();	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StringBuilder stringBuilder = new StringBuilder("<html><head><title>Rewards</title></head><body>");
		int projectId = Integer.parseInt(request.getParameter("projectId"));

		List<Reward> rewards = new ArrayList<>();
		rewards = rewardDao.getByProject(projectId);

		stringBuilder.append(
				"<br/></br><a href=\"reward?id=" + 0 + "\">" + "No thanks, I just want to help the project." + "</a>");

		for (int i = 0; i < rewards.size(); i++) {
			stringBuilder.append("<br/></br><a href=\"reward?id=" + rewards.get(i).getId() + "\">" + "$"
					+ rewards.get(i).getAmount() + "</a>");
			stringBuilder.append("</br>" + rewards.get(i).getReward());
		}

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
