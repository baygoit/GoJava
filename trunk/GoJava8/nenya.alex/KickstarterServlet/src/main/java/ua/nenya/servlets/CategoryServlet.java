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

//@WebServlet("/category")
public class CategoryServlet extends HttpServlet implements EnteringMode{
	private static final long serialVersionUID = 1L;
    
    public CategoryServlet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		DaoInitilizer initilizer = new DaoInitilizer();
		initilizer.initDao(switcher);
		CategoryDao categoryDao = initilizer.getCategoryDao();		 
        PrintWriter printWriter = response.getWriter();
        
        showCategories(categoryDao, printWriter);
       
	}


	private void showCategories(CategoryDao categoryDao, PrintWriter printWriter) {

        List<Category> categories = categoryDao.initCategories();
		printWriter.println("<h4>Choose one of the items bellow</h4>");
		for(int i = 0; i < categories.size(); i++){
			printWriter.println("<p>"+(i+1)+".	"+"<a href = \"projects?categoryIndex="+i+"\">"+categories.get(i).getName()+"</a></p>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
