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

import com.kickstarter.dao.Impl.PaymentDaoImpl;
import com.kickstarter.dao.Impl.ProjectDaoImpl;
import com.kickstarter.dao.Impl.QuestionDaoImpl;
import com.kickstarter.model.Project;
import com.kickstarter.model.Question;

@WebServlet("/SingleProjectServlet")
public class SingleProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	QuestionDaoImpl questionDao;

	@Autowired
	ProjectDaoImpl projectDao;

	@Autowired
	PaymentDaoImpl paymentDao;

	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int projectId = Integer.parseInt(request.getParameter("projectId"));
		Project project = projectDao.getOneProject(projectId);
		project.setGainedSum(paymentDao.getAll(projectId));
		List<Question> list = questionDao.getProjectQuestions(projectId);

		request.setAttribute("questions", list);
		request.setAttribute("project", project);
		request.getRequestDispatcher("/WEB-INF/SingleProject.jsp").forward(request, response);

	}

}
