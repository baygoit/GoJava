package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.config.DataSourceTypes;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;

@WebServlet("/project")
public class ProjectServlet extends HttpServlet {
	private DaoProvider daoProvider;
	private ProjectDao projectDao;
	private PaymentDao paymentDao;
	private QuestionDao questionDao;

	@Override
	public void init() throws ServletException {
		daoProvider = new DaoProvider(DataSourceTypes.POSTGRES);
		daoProvider.init();
		projectDao = daoProvider.getProjectReader();
		paymentDao = daoProvider.getPaymentReader();
		questionDao = daoProvider.getQuestionReader();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		
		Project selectedProject = projectDao.getProject(projectId);
		
		int pledged = paymentDao.getPledged(selectedProject.getId());
		
		StringBuilder stringBuilder = new StringBuilder("<html><head><title>Project</title></head><body>");

		stringBuilder.append("name: ").append(selectedProject.getName()).append("</br>");
		stringBuilder.append("funded: ").append(selectedProject.getFunded(pledged)).append("</br>");
		stringBuilder.append("daysToGo: ").append(selectedProject.getDaysToGo()).append("</br>");
		stringBuilder.append("pledged: ").append(pledged).append("</br>");
		stringBuilder.append("description: ").append(selectedProject.getDescription()).append("</br>");
		stringBuilder.append("owner: ").append(selectedProject.getOwner()).append("</br>");
		stringBuilder.append("goal: ").append(selectedProject.getGoal()).append("</br>");
		stringBuilder.append("linkVideo: ").append(selectedProject.getLinkVideo()).append("</br>");

		List<Question> questions = questionDao.getQuestions(projectId);
		for (Question question : questions) {
			stringBuilder.append("Question: '")
					.append(question.getQuestionText()).append("'</br>");
		}
		stringBuilder.append("<a href=\"payments?projectId=").append(projectId).append("\">")
		.append("to invest in the project").append("</a><br/>");
		stringBuilder.append("<a href=\"question?projectId=").append(projectId).append("\">")
		.append("to ask a question").append("</a><br/>");	
				
		stringBuilder.append("</body></html>");

		response.getWriter().append(stringBuilder.toString());

	}

}
