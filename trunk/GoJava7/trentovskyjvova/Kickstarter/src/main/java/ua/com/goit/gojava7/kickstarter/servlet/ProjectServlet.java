package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;

@WebServlet("/project")
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProjectDao projectDao;
	private PaymentDao paymentDao;
	private QuestionDao questionDao;

	@Override
	public void init() throws ServletException {
		ServletContext context = getServletContext();
		DaoProvider daoProvider = (DaoProvider) context.getAttribute(ContextListener.STORAGE_FACTORY);
		
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
		List<Question> questions = questionDao.getQuestions(projectId);
		
		request.setAttribute("selectedProject", selectedProject);
		request.setAttribute("pledged", pledged);
		request.setAttribute("questions", questions);
		request.getRequestDispatcher("/WEB-INF/jsp/project.jsp").forward(request, response);	
	}

}
