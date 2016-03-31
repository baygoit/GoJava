package com.anmertrix.page;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anmertrix.dao.CategoryDao;
import com.anmertrix.domain.Category;
import com.anmertrix.domain.Project;

public class ProjectsPage extends Page {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
 
        PrintWriter pw = resp.getWriter();
        CategoryDao categoryDao = page.getCategoryDao();
        String categoryIdStr = req.getParameter("categoryId");
		int categoryId = 0;
		try {
			categoryId = Integer.parseInt(categoryIdStr);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		Category category = categoryDao.getCategory(categoryId);
		pw.println("<H2>" + category.getName() + "</H2>");
		List<Project> projects = categoryDao.getProjectsByCategoryId(categoryId);
		
		pw.println("<ul>");
		for (Project project: projects) {
			pw.println("<li><a href=\"project?projectId=" + project.getId() + "\">" + project.getName() + "</a></li>");
		}
		pw.println("</ul>");
    }

}
