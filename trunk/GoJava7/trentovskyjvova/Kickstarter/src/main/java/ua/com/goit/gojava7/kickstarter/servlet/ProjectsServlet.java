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
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;

@WebServlet("/projects")
public class ProjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProjectDao projectDao;
	private PaymentDao paymentDao;
	
	@Override
	public void init() throws ServletException {
		ServletContext context = getServletContext();
		DaoProvider daoProvider = (DaoProvider) context.getAttribute(ContextListener.STORAGE_FACTORY);
		
		projectDao = daoProvider.getProjectReader();
		paymentDao = daoProvider.getPaymentReader();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		
		StringBuilder stringBuilder = new StringBuilder("<html><head><title>Projects</title></head><body>");
		stringBuilder.append("<table border=1 solid black cellspacing=0>");
		
		stringBuilder.append("<tr>");
		stringBuilder.append("<td>").append("project").append("</td>");
		stringBuilder.append("<td>").append("funded").append("</td>");
		stringBuilder.append("<td>").append("days to go").append("</td>");
		stringBuilder.append("<td>").append("pledged").append("</td>");
		stringBuilder.append("</tr>");

		List<Project> projects = projectDao.getProjects(categoryId);
		for (Project project : projects) {	
			int pledged = paymentDao.getPledged(project.getId());
			
			stringBuilder.append("<tr><td>");
			stringBuilder.append("<a href=\"project?projectId=").append(project.getId()).append("\">")
					.append(project.getName()).append("</a></td>");
			stringBuilder.append("<td>").append(project.getFunded(pledged)).append("</td>");
			stringBuilder.append("<td>").append(project.getDaysToGo()).append("</td>");
			stringBuilder.append("<td>").append(pledged).append("</td>");
			stringBuilder.append("</td></tr>");
		}	
		stringBuilder.append("</table>");
		stringBuilder.append("</body></html>");
		
		response.getWriter().append(stringBuilder.toString());
	}



}
