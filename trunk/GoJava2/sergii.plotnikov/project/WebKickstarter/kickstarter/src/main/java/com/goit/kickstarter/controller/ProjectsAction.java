package com.goit.kickstarter.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goit.kickstarter.dao.CategoryDAO;
import com.goit.kickstarter.dao.ProjectDAO;
import com.goit.kickstarter.model.Category;
import com.goit.kickstarter.model.Project;

public class ProjectsAction implements Action {
	
	private CategoryDAO categoryDao;
	private ProjectDAO projectDao;

	public ProjectsAction(CategoryDAO categoryDao, ProjectDAO projectDao) {
		this.categoryDao = categoryDao;
		this.projectDao = projectDao;
	}

	@Override
	public String doGet(HttpServletRequest req, HttpServletResponse resp) {
		int categoryId = Integer.valueOf(req.getParameter("category"));
		Category choice = categoryDao.getCategory(categoryId);

		List<Project> projects = projectDao.getProjects(categoryId);

		req.setAttribute("projects", projects);
		req.setAttribute("category", choice);
		return "projects.jsp";
	}

	@Override
	public String doPost(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}

}
