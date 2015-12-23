package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;
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

import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;

@WebServlet("/project")
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ProjectsServlet.class);
	
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private PaymentDao paymentDao;
	@Autowired
	private QuestionDao questionDao;
	
	@Override
	public void init() throws ServletException {
		log.info("Starting Spring autowiring...");
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		log.info("Ended Spring autowiring...");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("doGet");
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		log.debug("projectId: " + projectId);
		
		Project selectedProject = projectDao.getProject(projectId);
		log.debug("selectedProject: " + selectedProject);
		
		int pledged = paymentDao.getPledged(selectedProject.getId());
		log.debug("pledged: " + pledged);
		List<Question> questions = questionDao.getQuestions(projectId);
		log.debug("Questions: " + questions);
		
		request.setAttribute("selectedProject", selectedProject);
		request.setAttribute("pledged", pledged);
		request.setAttribute("questions", questions);
		request.getRequestDispatcher("/WEB-INF/jsp/project.jsp").forward(request, response);	
		log.info("Ended doGet");
	}

}
