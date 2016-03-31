package com.anmertrix.page;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anmertrix.dao.CategoryDao;
import com.anmertrix.domain.Project;

//@WebServlet("/project")
public class ProjectPage extends Page {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
 
        PrintWriter pw = resp.getWriter();
        CategoryDao categoryDao = page.getCategoryDao();
        String projectIdStr = req.getParameter("projectId");
		int projectId = 0;
		try {
			projectId = Integer.parseInt(projectIdStr);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		Project project = categoryDao.getProjectById(projectId);
		pw.println("<H2>" + project.getName() + "</H2>");
		
		pw.println("Description: " + project.getDescription() + "\n");
		pw.println("Required budget: " + project.getRequiredBudget() + "\n");
		pw.println("Gathered budget: " + project.getGatheredBudget() + "\n");
		pw.println("Days left: " + project.getDaysLeft() + "\n");
		pw.println("History: " + project.getHistory() + "\n");
		pw.println("Video URL: " + project.getURL() + "\n");
		pw.println("Question and answer: \n" + project.getQuestionAnswer());
		
		
    }
}
