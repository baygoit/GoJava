package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;

@WebServlet("/projects")
public class ProjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProjectDao projectDao;
	private PaymentDao paymentDao;
	private DaoProvider daoProvider;
	protected WebApplicationContext applicationContext;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext servletContext = config.getServletContext();
		applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);

		daoProvider = applicationContext.getBean(DaoProvider.class);
		//daoProvider.open();
		super.init(config);
	}
	
	@Override
	public void init() throws ServletException {		
		projectDao = daoProvider.getProjectReader();
		paymentDao = daoProvider.getPaymentReader();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		List<Project> projects = projectDao.getProjects(categoryId);
		
		request.setAttribute("projects", projects);
		request.setAttribute("paymentDao", paymentDao);
		request.getRequestDispatcher("/WEB-INF/jsp/projects.jsp").forward(request, response);	
	}



}
