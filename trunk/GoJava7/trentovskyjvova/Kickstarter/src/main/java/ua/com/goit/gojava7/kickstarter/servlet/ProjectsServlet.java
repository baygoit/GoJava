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

import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.domain.Project;

@WebServlet("/projects")
public class ProjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ProjectsServlet.class);
	
	@Autowired
	private ProjectDao projectDao;
	
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
		int categoryId = Integer.parseInt(request.getParameter("id"));
		log.debug("categoryId: {}", categoryId);
		List<Project> projects = projectDao.getProjects(categoryId);
		log.debug("Projects: {}", projects);
		
		request.setAttribute("projects", projects);
		request.getRequestDispatcher("/WEB-INF/jsp/projects.jsp").forward(request, response);	
		log.info("Ended doGet");
	}



}
