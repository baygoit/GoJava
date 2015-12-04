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
import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.dao.DaoFactory;
import ua.com.goit.gojava7.kickstarter.dao.storage.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.domain.Project;

/**
 * Servlet implementation class ProjectServlet
 */
@WebServlet({ "/ProjectServlet", "/project" })
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProjectStorage projectStorage;
	DataSource dataSource = DataSource.MEMORY;
	DaoFactory daoFactory = new DaoFactory(dataSource);
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		projectStorage = daoFactory.getProjectStorage();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<html><head><title>Categories</title></head><body>");
	String projectName = request.getParameter("name");
		Project project = projectStorage.getProjectByName(projectName);
		stringBuilder.append("Project: " + project.getProjectName() + "   |  Category: "
				+ project.getCategoryName());
		stringBuilder.append(project.getProjectEndTime());
		stringBuilder.append("[ " + project.getProjectDescription() + " ]");
		stringBuilder.append("History: " + ConsolePrinter.getBlankStringIfNull(project.getProjectHistory()));
		stringBuilder.append("Demo: " +  ConsolePrinter.getBlankStringIfNull(project.getDemoLink()));
		stringBuilder.append("Funded: " + project.getFundedPercentage() + " | Pledged: $"
				+ project.getPledged());
		stringBuilder.append("Donate bonuses:");
		project.getPaymentBonus().getBonuses().forEach((money, bonus) -> {
			stringBuilder.append(money + "$ - " + bonus);
		});
		stringBuilder.append("Questions and Answers:");
		project.getQuestionsAndAnswers().forEach((q, a) -> {
			stringBuilder.append("Q: " + q);
			stringBuilder.append("A: " + a);
			stringBuilder.append("-------------------------------------");
		});
		stringBuilder.append("</body></html>");
		response.getWriter().append(stringBuilder);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
