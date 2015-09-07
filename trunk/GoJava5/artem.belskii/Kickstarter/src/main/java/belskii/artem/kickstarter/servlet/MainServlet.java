package belskii.artem.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import belskii.artem.kickstarter.dao.project.Project;
import belskii.artem.kickstarter.mvc.controller.CategoryController;
import belskii.artem.kickstarter.mvc.controller.ProjectController;
import belskii.artem.kickstarter.mvc.controller.QuoteController;
import belskii.artem.kickstarter.mvc.model.CategoryModel;
import belskii.artem.kickstarter.mvc.model.ProjectModel;
import belskii.artem.kickstarter.mvc.model.QuoteModel;
import belskii.artem.kickstarter.mvc.view.CategoryView;
import belskii.artem.kickstarter.mvc.view.ProjectView;

public class MainServlet extends HttpServlet{
	private CategoryController category = new CategoryController(new CategoryModel(), new CategoryView());
	private ProjectController project = new ProjectController(new ProjectModel(), new ProjectView());
	private QuoteController quote = new QuoteController(new QuoteModel());
	private int categoryId;
	
	
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

	        }
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		int projectid=Integer.valueOf(req.getParameter("projectid"));
		Project projectforEdit = project.getProjectById(projectid);
		String question = req.getParameter("question");
		if (question.length()>0){
			projectforEdit.asqAQuestion(req.getParameter("question"));
			project.save(projectforEdit);
		}
		
		Long donate=0L;
		if(!req.getParameter("donate").equals("")){
			donate=Long.valueOf(req.getParameter("donate"));			
		}

		Long customDonate = 0L;
		if(!req.getParameter("customDonate").equals("")){
			customDonate =Long.valueOf(req.getParameter("customDonate"));
		}

		if (donate>0 || customDonate>0){
			if (customDonate>0){
				projectforEdit.updateBalance(customDonate);
				project.save(projectforEdit);
			} else {
				projectforEdit.updateBalance(donate);
				project.save(projectforEdit);
			}
		}
		this.showProjectDetails(req,resp);
	}


	private void showProjectDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int projectid=Integer.valueOf(req.getParameter("projectid"));
		req.setAttribute("project", project.getProjectById(projectid));
		req.setAttribute("paymetVariants", project.getProjectById(projectid).getPaymetVariants());
		req.setAttribute("categoryId", categoryId);
		req.getRequestDispatcher("projectdetails.jsp").forward(req, resp);
	}

	private void showProjectsFromCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		categoryId=Integer.valueOf(req.getParameter("categoryId"));
		req.setAttribute("categoryName", category.getCategoryList().get(categoryId-1));
		req.setAttribute("projectsFromCategory",project.getProjectFromCategory(categoryId).values());
		req.getRequestDispatcher("projects.jsp").forward(req, resp);
	}

	private void showMainPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		Hello hello = (Hello) context.getBean("helloBean");
		req.setAttribute("quote", quote.getRandomQuote());
		req.setAttribute("hello", hello.getHello());
		req.setAttribute("categoryList", category.getCategoryList().values());
		req.getRequestDispatcher("main.jsp").forward(req, resp);
	}


	


	
}
