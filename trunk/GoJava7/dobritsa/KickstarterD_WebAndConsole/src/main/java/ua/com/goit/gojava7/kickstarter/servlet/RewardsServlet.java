package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.DaoFactory;
import ua.com.goit.gojava7.kickstarter.dao.MyDataSource;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;

@WebServlet("/rewards")
public class RewardsServlet extends HttpServlet {
	
	private DaoFactory daoFactory;
	private RewardDao rewardDao;
	private ProjectDao projectDao;
	private CategoryDao categoryDao;

	@Override
	public void init() {
		MyDataSource dataType = (MyDataSource) getServletContext().getAttribute("mode");
		daoFactory = new DaoFactory(dataType);
		rewardDao = daoFactory.getRewardDAO();
		projectDao = daoFactory.getProjectDAO();
		categoryDao = daoFactory.getCategoryDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		
		request.setAttribute("category", categoryDao.get(projectDao.get(projectId).getCategoryId()));	
		request.setAttribute("project", projectDao.get(projectId));
		request.setAttribute("rewards", rewardDao.getByProject(projectId));
		request.getRequestDispatcher("/WEB-INF/jsp/rewards.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		doGet(request, response);
	}

}
