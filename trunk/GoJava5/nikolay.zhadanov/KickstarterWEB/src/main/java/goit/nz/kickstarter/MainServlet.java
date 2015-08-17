package goit.nz.kickstarter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
        out.println("<h1>Welcome to Kickstarter!<h1>");
		Product p = new Product("yyy");
		req.setAttribute("map", "test");
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}

 class Product {
	 private String name;
	 
	 public Product(String name) {
		 this.name = name;
	 }
	 
	 public String getName() {
		 return name;
	 }
 }