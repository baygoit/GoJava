package ua.com.goit.gojava7.kickstarter.servlet;

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
		MyDataSource dataType = (MyDataSource) getServletContext().getAttribute("mode");
		daoFactory = new DaoFactory(dataType);
		projectDao = daoFactory.getProjectDAO();
		rewardDao = daoFactory.getRewardDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int rewardId = Integer.parseInt(request.getParameter("id"));
		int amount;
		StringBuilder stringBuilder = new StringBuilder("<html><head><title>Payment</title></head><body>");

		if (rewardId != 0) {
			Reward reward = rewardDao.get(rewardId);
			amount = reward.getAmount();
			//Project project = projectDao.get(reward.getProjectId());			
			
		} else {
			amount = Integer.parseInt(request.getParameter("amount"));
			
		}
		stringBuilder.append("Amount of your donation is $" + amount);
		response.getWriter().append(stringBuilder);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		doGet(request, response);
	}

}
