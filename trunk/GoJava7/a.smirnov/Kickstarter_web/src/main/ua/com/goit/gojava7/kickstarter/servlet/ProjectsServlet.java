package main.ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.ua.com.goit.gojava7.kickstarter.beans.Project;
import main.ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import main.ua.com.goit.gojava7.kickstarter.config.DataSource;
import main.ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import main.ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import main.ua.com.goit.gojava7.kickstarter.dao.ProjectDao;

@WebServlet(urlPatterns = "/category")
public class ProjectsServlet extends HttpServlet {
	private static final String SEPARATOR = "*********************************************************";
	private DaoProvider daoProvider;
	private ProjectDao projectDao;
	private CategoryDao categoryDao;
	private PaymentDao paymentDao;
	
	@Override
	public void init() throws ServletException {
		daoProvider = new DaoProvider(DataSource.MYSQL);
		daoProvider.open();
		projectDao = daoProvider.getProjectDao();
		categoryDao = daoProvider.getCategoryDao();
		paymentDao = daoProvider.getPaymentDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int selectedCategoryId = Integer.parseInt(req.getParameter("id"));
		List<Project> projects = projectDao.getProjectsFromCategory(selectedCategoryId);
		
		StringBuilder result = new StringBuilder().
				append("<html>").
					append("<head>").
						append("<title> Categories </title>").
					append("</head>").
					
					append("<body>");
					if (projects.isEmpty()) {
						result.append("<br> There is no project </br>");
					} else {
						result.
						append("<br>Please select project :</br>").
						
						append("<ol>");
						for (Project project : projects) {
							result.
								append("<li>").
									append("<a href=\"project?id=" + project.getUniqueID() + "\"> Title : " + project.getTitle() + "</a>").
									append("<br> Short description : " + project.getBriefDescription() + "</br>").
									append("<br> Required $ : " + project.getRequiredSum() + "</br>").
									append("<br> Collected $ : " + project.getCollectedSum() + "</br>").
									append("<br> Days left : " + project.getDaysLeft() + "</br>").
								append("</li>");
						}
						result.
							append("</ol>").
							append(SEPARATOR);
					}
		result.
			append("</body>").
			append("</html>");
		resp.getWriter().append(result);
	}

	@Override
	public void destroy() {
		daoProvider.close();
	}
}
