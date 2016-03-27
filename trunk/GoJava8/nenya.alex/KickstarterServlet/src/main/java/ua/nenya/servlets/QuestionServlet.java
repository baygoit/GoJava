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

//@WebServlet("/question")
public class QuestionServlet extends HttpServlet implements EnteringMode{
	private static final long serialVersionUID = 1L;
       
    public QuestionServlet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		DaoInitilizer initilizer = new DaoInitilizer();
		initilizer.initDao(switcher);
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
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
