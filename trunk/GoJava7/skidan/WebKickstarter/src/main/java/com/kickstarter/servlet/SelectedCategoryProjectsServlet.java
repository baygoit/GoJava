package com.kickstarter.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;


import com.kickstarter.dao.interfaces.DbProjectDaoImpl;
import com.kickstarter.model.Project;


@WebServlet("/SelectedCategoryProjectsServlet")
public class SelectedCategoryProjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	DbProjectDaoImpl projectDao;
  
	
	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
			      getServletContext());
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoryTitlet = request.getParameter("categoryTitle");
		List<Project> projectList = projectDao.getAll(categoryTitlet);
		
		
		request.setAttribute("projectList", projectList);
		request.getRequestDispatcher("/WEB-INF/SelectedCategoryProjects.jsp").forward(request, response);

	}

	
	

}
