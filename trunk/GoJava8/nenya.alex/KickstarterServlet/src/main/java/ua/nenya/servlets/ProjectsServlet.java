package ua.nenya.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nenya.dao.CategoryDao;
import ua.nenya.main.DaoInitilizer;
import ua.nenya.project.Category;
import ua.nenya.project.Project;

//@WebServlet("/projects")
public class ProjectsServlet extends HttpServlet implements EnteringMode{
	private static final long serialVersionUID = 1L;
    
    public ProjectsServlet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		DaoInitilizer initilizer = new DaoInitilizer();
		initilizer.initDao(switcher);
		CategoryDao categoryDao = initilizer.getCategoryDao();	
        List<Category> categories = categoryDao.initCategories();
		String categoryIndexStr = request.getParameter("categoryIndex");
		
		int categoryIndex = 0;
		try{
		categoryIndex = Integer.parseInt(categoryIndexStr);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		Category category = categories.get(categoryIndex);
		showProjects(categoryIndex, categoryDao, category, printWriter);
	}

	
	private void showProjects(int categoryIndex, CategoryDao categoryDao, Category category, PrintWriter printWriter) {
		List<Project> projects = categoryDao.initProjects(category);
		printWriter.println("<h4>Choose one of the items bellow</h4>");
		for(int i = 0; i < projects.size(); i++){
			Project project = projects.get(i);
			printWriter.println("<p>"+(i+1)+".	"+"<a href = \"project?projectIndex="+i+"&categoryIndex="+categoryIndex+"\">"+project.getName()+"</a></p>");
			showShortInfoProject(project, printWriter);
		}
	}


	private void showShortInfoProject(Project project, PrintWriter printWriter) {
		printWriter.println("<p> Project name:		" + project.getName()+"</p>");
		printWriter.println("<p> Description:		" + project.getDescription()+"</p>");
		printWriter.println("<p> Needed amount:		" + project.getNeededAmount()+"</p>");
		printWriter.println("<p> Available amount:	" + project.getAvailableAmount()+"</p>");
		printWriter.println("<p> Remaining days:		" + project.getDaysRemain()+"</p>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
