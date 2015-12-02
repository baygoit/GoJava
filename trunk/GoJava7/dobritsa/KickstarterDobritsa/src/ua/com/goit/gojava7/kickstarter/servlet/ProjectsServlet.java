package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.DaoFactory;
import ua.com.goit.gojava7.kickstarter.dao.MyDataSource;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.domain.Project;

@WebServlet("/projects")
public class ProjectsServlet extends HttpServlet {

	private DaoFactory daoFactory;
	private ProjectDao projectDao;
	private CategoryDao categoryDao;

	@Override
	public void init() throws ServletException {
		daoFactory = new DaoFactory(MyDataSource.DB);
		projectDao = daoFactory.getProjectDAO();
		categoryDao = daoFactory.getCategoryDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		StringBuilder stringBuilder = new StringBuilder("<html><head><title>Projects</title></head><body>");		
		
		int categoryId = Integer.parseInt(request.getParameter("id"));		
		stringBuilder.append("<h1>" + categoryDao.get(categoryId).getName() + "</h1>");
		List<Project> projects = new ArrayList<>();
		projects = projectDao.getByCategory(categoryId);

		for (int i = 0; i < projects.size(); i++) {
			stringBuilder.append("<br/><a href=\"project?id=" + projects.get(i).getId() + "\">" + projects.get(i).getName()
					+ "</a>");
			stringBuilder.append("</br>Description: \t" + projects.get(i).getDescription());
			stringBuilder.append("</br>Goal: \t\t" + projects.get(i).getGoal());
			stringBuilder.append("</br>Pledged: \t" + projects.get(i).getPledged());
			stringBuilder.append("</br>Days to go: \t" + projects.get(i).getDaysToGo() + "<br/>");	
		}
		stringBuilder.append("</body></html>");
		response.getWriter().append(stringBuilder);
	}
}
