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
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.domain.Project;

@WebServlet("/project")
public class ProjectServlet extends HttpServlet {
	
	private DaoFactory daoFactory;
	private Project project;
	private ProjectDao projectStorage;
	private QuestionDao questionStorage;
	private RewardDao rewardStorage;
	
	@Override
	public void init() throws ServletException {
		daoFactory = new DaoFactory(MyDataSource.DB);
		daoFactory.open();
		questionStorage = daoFactory.getQuestionDAO();
		rewardStorage = daoFactory.getRewardDAO();
		projectStorage = daoFactory.getProjectDAO();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int projectId = Integer.parseInt(request.getParameter("id"));
		project = projectStorage.get(projectId);
		
		StringBuilder stringBuilder = new StringBuilder("<html><head><title>Project</title></head><body>");
		stringBuilder.append("About project:</br>");
		
		stringBuilder.append("</br>Name: \t\t" + project.getName());
		stringBuilder.append("\n<i>Name: \t\t" + project.getName());
		stringBuilder.append("</br>Description: \t" + project.getDescription());
		stringBuilder.append("</br>Goal: \t\t" + project.getGoal());
		stringBuilder.append("</br>Pledged: \t" + project.getPledged());
		stringBuilder.append("</br>Days to go: \t" + project.getDaysToGo());		
		stringBuilder.append("</br>History: \t" + project.getHistory());		
		stringBuilder.append("</br>Demo video: \t" + project.getLink());		
		
		response.getWriter().append(stringBuilder);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
