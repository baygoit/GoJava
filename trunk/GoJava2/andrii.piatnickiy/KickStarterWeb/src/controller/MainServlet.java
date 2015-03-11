package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CategoriesDAO;
import model.Category;

public class MainServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		
		response.setContentType("text/html;charset=utf-8");

		PrintWriter pw = response.getWriter();
		ConnectionToDB connectionToDB = new ConnectionToDB();
		
		Connection connection = connectionToDB.getConnection();
		CategoriesDAO categoriesDAO = new CategoriesDAO(connection);		
		LinkedList<Category> categories = categoriesDAO.getCategoriesList();

		request.setAttribute("categories", categories);
		request.getRequestDispatcher("/categories.jsp").forward(request, response);
		

	}

}
