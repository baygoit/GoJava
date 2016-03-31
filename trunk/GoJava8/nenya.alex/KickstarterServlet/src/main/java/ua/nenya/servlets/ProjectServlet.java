package ua.nenya.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nenya.dao.CategoryDao;
import ua.nenya.project.Category;
import ua.nenya.project.Project;
import ua.nenya.project.Question;

//@WebServlet("/project")
public class ProjectServlet extends CommonServlet{
	private static final long serialVersionUID = 1L;
    
    public ProjectServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		CategoryDao categoryDao = initilizer.getCategoryDao();
		List<Category> categories = categoryDao.initCategories();
		String projectIndexStr = request.getParameter("projectIndex");
		String categoryIndexStr = request.getParameter("categoryIndex");
		int projectIndex = 0;
		int categoryIndex = 0;
		try{
		projectIndex = Integer.parseInt(projectIndexStr);
		categoryIndex = Integer.parseInt(categoryIndexStr);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		Category category = categories.get(categoryIndex); 
		List<Project> projects = categoryDao.initProjects(category);
		Project project = projects.get(projectIndex);
		printWriter.println("<p><a href = \"projects?categoryIndex="+categoryIndex+"\"> Back </a></p>");
		showAllProject(project, printWriter, categoryDao);
		printWriter.println("<p><h2>1. <a href = \"investment?categoryIndex="+categoryIndex+"&projectIndex="+projectIndex+"\">Invest in project</a></h2></p>");
		printWriter.println("<p><h2>2. <a href = \"question?categoryIndex="+categoryIndex+"&projectIndex="+projectIndex+"\">Ask a question</a></h2></p>");
	}

	
	private void showAllProject(Project project, PrintWriter printWriter, CategoryDao categoryDao) {
		printWriter.println("<p> <h3>" + project.getName()+"</h3></p>");
		printWriter.println("<p> Project name:		" + project.getName()+"</p>");
		printWriter.println("<p> Description:		" + project.getDescription()+"</p>");
		printWriter.println("<p> Needed amount:		" + project.getNeededAmount()+"</p>");
		printWriter.println("<p> Available amount:	" + project.getAvailableAmount()+"</p>");
		printWriter.println("<p> Remaining days:		" + project.getDaysRemain()+"</p>");
		printWriter.println("<p>History:		" + project.getHistory()+"</p>");
		printWriter.println("<p>Video:		" + project.getVideo()+"</p>");
		printWriter.println("<p>Q&A:		" +"</p>");
		showQuestions(project, printWriter, categoryDao);
	}

	private void showQuestions(Project project, PrintWriter printWriter, CategoryDao categoryDao) {
		List<Question> questions = categoryDao.initQuestions(project);
		
			for (int i = 0; i < questions.size(); i++) {
				printWriter.println( "<p>"+ (i + 1) +".	"+ questions.get(i).getName()+"</p>");
			}
			if (questions.size() == 0) {
				printWriter.println("<p>No questions!</p>");
			}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
