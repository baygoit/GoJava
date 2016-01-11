package com.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.kickstarter.dao.Impl.ProjectDaoImpl;
import com.kickstarter.dao.Impl.QuestionDaoImpl;
import com.kickstarter.model.Project;

@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	QuestionDaoImpl questionDao;
	@Autowired
	ProjectDaoImpl projectDao;

	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		String question = request.getParameter("question");
		if (question.length() >= 1) {
			Project project = projectDao.getOneProject(projectId);
			questionDao.add(question, project);
		}
		response.sendRedirect("SingleProjectServlet?projectId=" + projectId);

	}
}