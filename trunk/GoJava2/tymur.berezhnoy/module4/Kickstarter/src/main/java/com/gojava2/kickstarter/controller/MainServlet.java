 package com.gojava2.kickstarter.controller;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.gojava2.kickstarter.dao.CategoriesDAO;
import com.gojava2.kickstarter.dao.ProjectsDAO;
import com.gojava2.kickstarter.dao.QuotesDAO;
import com.gojava2.kickstarter.model.Category;
import com.gojava2.kickstarter.model.Project;
import com.gojava2.kickstarter.model.Quote;

@Controller
public class MainServlet extends HttpServlet {
	
	private String nameJsp;
		
	@Autowired
	private QuotesDAO quotesDAO;
	
	@Autowired
	private CategoriesDAO categoriesDAO;
	
	@Autowired
	private ProjectsDAO projectsDAO;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action = req.getRequestURI().substring(req.getContextPath().length());

		if(action.equals("/categories")) {

			Quote quote = quotesDAO.getRandomQuote();
			StringBuilder builder = new StringBuilder();
			builder.append("\"").append(quote.getContent()).append("\"")
			.append(quote.getCopyrightSymbol()).append(quote.getAuthor());
			
			LinkedHashSet<Category> categories = categoriesDAO.getCategories();
			nameJsp = "categories";
			
			req.setAttribute("quote", quote);
			redirect(req, resp, categories, nameJsp);
		} else if(action.equals("/projects")) {
			int categoryId = Integer.valueOf(req.getParameter("categoryId"));
			String categoryName = String.valueOf(req.getParameter("categoyName"));
			
			List<Project> projects = projectsDAO.getProjects(new Category(categoryId, categoryName));
			nameJsp = "projects";
			
			redirect(req, resp, projects, nameJsp);
		} else if(action.equals("/project")) {
			int projectId = Integer.valueOf(req.getParameter("id"));
			
			Project project = projectsDAO.getProject(projectId);
			nameJsp = "project";
			
			redirect(req, resp, project, nameJsp);
		}
	}

	private void redirect(HttpServletRequest req, HttpServletResponse resp,
			Object content, String name)
			throws ServletException, IOException {
		req.setAttribute(name, content);
		req.getRequestDispatcher(name + ".jsp").forward(req, resp);
	}
}