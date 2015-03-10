package ua.com.goit.gojava.kickstarter.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava.kickstarter.dao.CatalogDao;
import ua.com.goit.gojava.kickstarter.dao.ConnectionPool;
import ua.com.goit.gojava.kickstarter.data.Category;



public class MainServlet extends HttpServlet {
   
	static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
	}

	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String request = req.getRequestURI();
		request = request.substring(req.getContextPath().length(), request.length());
		ConnectionPool pool = new ConnectionPool();
		Connection connection = pool.getConnection();
		if(request.startsWith("/categories"));{
		  CatalogDao catalog = new CatalogDao(connection);
		  List<Category> categories = catalog.getCatalog(); 
		  
		  req.setAttribute("catalog", categories);
		  req.getRequestDispatcher("catalog.jsp").forward(req,resp); 
		 
		}
		
	}

	
	 public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        System.out.println(req.getParameterMap().toString());
	    }


}
