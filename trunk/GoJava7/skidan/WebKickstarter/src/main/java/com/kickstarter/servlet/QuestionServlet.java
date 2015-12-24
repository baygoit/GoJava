package com.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.kickstarter.dao.interfaces.DbProjectDaoImpl;
import com.kickstarter.dao.interfaces.DbQuestionDaoImpl;

@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	DbQuestionDaoImpl questionDao;
	@Autowired
	DbProjectDaoImpl projectDao;

	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("projectId"));
		String question = request.getParameter("question");
		if (question.length() >= 1) {
			String projectTitle = projectDao.getOne(id).getTitle();
			questionDao.add(question, projectTitle);
		}
		response.sendRedirect("SingleProjectServlet?projectId=" + id);

	}
}