package com.anmertrix.page;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anmertrix.domain.Project;

public class ProjectPage extends Page {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String projectIdStr = request.getParameter("projectId");
		int projectId = 0;
		try {
			projectId = Integer.parseInt(projectIdStr);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		Project project = projectDao.getProjectById(projectId);
		
        request.setAttribute("project", project);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/project.jsp");
        dispatcher.forward(request, response);
		
		
    }
}
