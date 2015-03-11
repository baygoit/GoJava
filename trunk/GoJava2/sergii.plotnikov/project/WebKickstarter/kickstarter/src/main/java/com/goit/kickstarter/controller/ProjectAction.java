package com.goit.kickstarter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goit.kickstarter.dao.ProjectDAO;
import com.goit.kickstarter.model.Project;

public class ProjectAction implements Action {

	private ProjectDAO projectDao;
	
	public ProjectAction(ProjectDAO projectDao){
		this.projectDao=projectDao;
	}

	@Override
	public String doGet(HttpServletRequest req, HttpServletResponse resp) {
		int projectId = Integer.valueOf(req.getParameter("project"));
		int categoryId = Integer.valueOf(req.getParameter("category"));

		Project project = projectDao.getProject(projectId);

		req.setAttribute("project", project);
		req.setAttribute("categoryId", categoryId);
		return "project.jsp";
	}

	@Override
	public String doPost(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

}
