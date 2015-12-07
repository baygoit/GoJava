package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.config.DataSource;
import ua.com.goit.gojava7.kickstarter.dao.DaoFactory;
import ua.com.goit.gojava7.kickstarter.dao.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.dao.storage.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.domain.Project;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet({ "/CategoryServlet", "/category" })
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DataSource dataSource = DataSource.MEMORY;
	CategoryStorage categoryStorage;
	ProjectStorage projectStorage;
      DaoFactory daoFactory = new DaoFactory(dataSource);


	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		categoryStorage = daoFactory.getCategoryStorage();
		projectStorage = daoFactory.getProjectStorage();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<html><head><title>Categories</title></head><body>");
		int categoryId = Integer.parseInt(request.getParameter("id"));
		List<Project> projects =  projectStorage.getByCategory(categoryStorage.getCategoryById(categoryId).getCategoryName());
		stringBuilder.append("Category -  " +categoryStorage.getCategoryById(categoryId).getCategoryName() + "<br>");
		projects.forEach(project ->{
			stringBuilder.append("<a href=\"project?name=" + project.getProjectName() + "\">" + project.getProjectName() + "</a><br/>");
		});
		stringBuilder.append("</body></html>");
		response.getWriter().append(stringBuilder);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
