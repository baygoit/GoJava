package com.goit.kickstarter.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.goit.kickstarter.dao.CategoryDAO;
import com.goit.kickstarter.dao.FaqDAO;
import com.goit.kickstarter.dao.ProjectDAO;

@Controller
public class MainServlet extends HttpServlet {

	@Autowired
	private CategoryDAO categoryDao;

	@Autowired
	private ProjectDAO projectDao;

	@Autowired
	private FaqDAO faqDao;
	
	private Map <String, Action>actions = new HashMap<String, Action>();

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
				config.getServletContext());
		CategoriesAction categoriesAction = new CategoriesAction(categoryDao);
		actions.put("/", categoriesAction);
		actions.put("/categories", categoriesAction);
		actions.put("/projects", new ProjectsAction(categoryDao, projectDao));
		actions.put("/project", new ProjectAction(projectDao));
		actions.put("/faq", new FaqAction(faqDao));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Action action = actions.get(getActionString(req));
		String jsp = action.doGet(req, resp);
		req.getRequestDispatcher(jsp).forward(req, resp);

//		if (action.equals("/payment")) {
//			projectId = Integer.valueOf(req.getParameter("project"));
//
//			Project project = ProjectDAO.getProject(projectId);
//			
//			req.setAttribute("project", project);
//			
//			req.getRequestDispatcher("project.jsp").forward(req, resp);
//		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		Action action = actions.get(getActionString(req));
		String jsp = action.doPost(req, resp);
		req.getRequestDispatcher(jsp).forward(req, resp);
	}
	
	private String getActionString(HttpServletRequest req) {
		String requestURI = req.getRequestURI();
		String action = requestURI.substring(req.getContextPath().length(),	requestURI.length());
		return action;
	}
}