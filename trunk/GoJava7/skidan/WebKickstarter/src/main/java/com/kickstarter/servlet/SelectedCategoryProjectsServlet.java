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

import com.kickstarter.dao.interfaces.ProjectDaoImpl;
import com.kickstarter.dao.interfaces.PaymentDaoImpl;
import com.kickstarter.model.Project;

@WebServlet("/SelectedCategoryProjectsServlet")
public class SelectedCategoryProjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	ProjectDaoImpl projectDao;

	@Autowired
	PaymentDaoImpl paymentDao;

	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int categoryId =Integer.valueOf(request.getParameter("categoryId"));
		List<Project> projectList = projectDao.getAll(categoryId);
		for (Project p : projectList) {
			p.setGainedSum(paymentDao.getAll(p.getId()));
		}

		request.setAttribute("projectList", projectList);
		request.getRequestDispatcher("/WEB-INF/SelectedCategoryProjects.jsp").forward(request, response);

	}

}
