package ua.com.goit.gojava7.kickstarter.dao.db;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.dao.DaoFactory;
import ua.com.goit.gojava7.kickstarter.dao.MyDataSource;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {

	DaoFactory daoFactory;
	ProjectDao projectDao;
	RewardDao rewardDao;

	@Override
	public void init() {
		daoFactory = new DaoFactory(MyDataSource.DB);
		projectDao = daoFactory.getProjectDAO();
		rewardDao = daoFactory.getRewardDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int rewardId = Integer.parseInt(request.getParameter("id"));
		StringBuilder stringBuilder = new StringBuilder("<html><head><title>Payment</title></head><body>");

		if (rewardId != 0) {
			Reward reward = rewardDao.get(rewardId);
			Project project = projectDao.get(reward.getProjectId());		
			stringBuilder.append("Amount of your donation is $" + reward.getAmount());
		} else if (rewardId == 0) {
			stringBuilder.append("Enter pledge amount from $1");
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
