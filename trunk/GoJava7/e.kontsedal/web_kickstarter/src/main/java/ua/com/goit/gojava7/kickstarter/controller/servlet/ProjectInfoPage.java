package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.DAO.dbStorage.mysql.PaymentDbStorage;
import ua.com.goit.gojava7.kickstarter.DAO.dbStorage.mysql.ProjectDbStorage;
import ua.com.goit.gojava7.kickstarter.DAO.dbStorage.mysql.QuestionDbStorage;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.model.Question;

@WebServlet("/project")
public class ProjectInfoPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	ProjectDbStorage projectStorage;
	@Autowired
	PaymentDbStorage paymentStorage;
	@Autowired
	QuestionDbStorage questionStorage;

	@Override
	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int projectId = Integer.parseInt(request.getParameter("id"));
		Project project = projectStorage.getProjectById(projectId);
		List<Question> questions = new ArrayList<>();
		questions = questionStorage.getQuestionsFromSelectedCategory(projectId);

		request.setAttribute("project", project);
		request.setAttribute("payment", paymentStorage.getSummaryProjectCostsCollected(projectId));
		request.setAttribute("questions", questions);

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/project.jsp");
		view.forward(request, response);
	}

}
