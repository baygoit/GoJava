package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;

@WebServlet("/project")
public class ProjectServlet extends HttpServlet {

	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private QuestionDao questionDao;
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int projectId = Integer.parseInt(request.getParameter("id"));
		
		request.setAttribute("category", categoryDao.get(projectDao.get(projectId).getCategoryId()));	
		request.setAttribute("project", projectDao.get(projectId));
		request.setAttribute("questions", questionDao.getByProject(projectId));
		request.getRequestDispatcher("/WEB-INF/jsp/project.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
