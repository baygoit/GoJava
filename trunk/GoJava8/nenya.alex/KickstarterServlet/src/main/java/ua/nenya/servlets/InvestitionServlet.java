package ua.nenya.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nenya.dao.CategoryDao;
import ua.nenya.project.Category;

//@WebServlet("/investment")
public class InvestitionServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;
     
    public InvestitionServlet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		initDao();
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
		printWriter.println("<p><a href = \"project?categoryIndex="+categoryIndex+"&projectIndex="+projectIndex+"\"> Back </a></p>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
