package belskii.artem.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import belskii.artem.kickstarter.mvc.controller.CategoryController;
import belskii.artem.kickstarter.mvc.controller.ProjectController;
import belskii.artem.kickstarter.mvc.controller.QuoteController;
import belskii.artem.kickstarter.mvc.model.CategoryModel;
import belskii.artem.kickstarter.mvc.model.ProjectModel;
import belskii.artem.kickstarter.mvc.model.QuoteModel;
import belskii.artem.kickstarter.mvc.view.CategoryView;
import belskii.artem.kickstarter.mvc.view.ProjectView;
//implements DoGetServlet 

public class MainServlet extends HttpServlet{
	private CategoryController category = new CategoryController(new CategoryModel(), new CategoryView());
	private ProjectController project = new ProjectController(new ProjectModel(), new ProjectView());
	private QuoteController quote = new QuoteController(new QuoteModel());
	
	public String getUserRequest(HttpServletRequest req){
		String url = req.getRequestURI();
		return url.substring(req.getContextPath().length());
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	       String userRequest = getUserRequest(req);
	        if (userRequest.equals("/main")) {
	            showMainPage(req, resp);
	        } else if (userRequest.startsWith("/projects")) {
	            showProjectsFromCategory(req, resp);
	        } else if (userRequest.startsWith("/projectdetails")) {
	            showProjectDetails(req, resp);
	        } else {
	            // 404
	        }
		
		
//		req.setAttribute("quote", quote.getRandomQuote());
//		req.setAttribute("categoryList", category.getCategoryList().values());
//		req.getRequestDispatcher("main.jsp").forward(req, resp);
//
//		if (getUserRequest(req).equals("/projects")){
//			int categoryId=Integer.valueOf(req.getParameter("categoryId"));
//			req.setAttribute("projectFromCategory","some projects");
//			req.getRequestDispatcher("projects.jsp").forward(req, resp);
//		}
		

	}

	private void showProjectDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long projectid=Long.valueOf(req.getParameter("projectid"));
		req.setAttribute("project", project.getProjectById(projectid));
		req.getRequestDispatcher("projectdetails.jsp").forward(req, resp);
		
	}

	private void showProjectsFromCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int categoryId=Integer.valueOf(req.getParameter("categoryId"));
		req.setAttribute("categoryName", category.getCategoryList().get(categoryId-1));
		req.setAttribute("projectsFromCategory",project.getProjectFromCategory(categoryId).values());
		req.getRequestDispatcher("projects.jsp").forward(req, resp);
	}

	private void showMainPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("quote", quote.getRandomQuote());
		req.setAttribute("categoryList", category.getCategoryList().values());
		req.getRequestDispatcher("main.jsp").forward(req, resp);
		
	}

}
