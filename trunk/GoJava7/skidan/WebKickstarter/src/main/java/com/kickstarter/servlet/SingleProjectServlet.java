package com.kickstarter.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kickstarter.dao.interfaces.DbProjectDaoImpl;
import com.kickstarter.dao.interfaces.DbQuestionDaoImpl;
import com.kickstarter.model.Project;
import com.kickstarter.model.Question;

@WebServlet("/SingleProjectServlet")
public class SingleProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DbQuestionDaoImpl questionDao;
	DbProjectDaoImpl projectDao;

	public void init() throws ServletException {
		projectDao = new DbProjectDaoImpl();
		questionDao = new DbQuestionDaoImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int projectId = Integer.parseInt(request.getParameter("projectId"));
		Project project = projectDao.getOne(projectId);
		List<Question> list =  questionDao.getProjectQuestions(project.getTitle());
		
		request.setAttribute("questions", list);
		request.setAttribute("project",project);
		request.getRequestDispatcher("/WEB-INF/SingleProject.jsp").forward(request, response);
		
		
		
		
		
		
//		StringBuilder sb = new StringBuilder("<html><head><title>SelectedProject</title></head><body>");
//		sb.append("<h1 style= \"text-align:center\">" + "Welcome to " + project.getTitle() + "</h1>");
//		sb.append("Project description : " + project.getDiscription() + "<br>");
//		sb.append("Days left till ending : " + project.getDaysLeft() + "<br>");
//		sb.append("Total required sum : " + project.getRequiredSum() + "<br>");
//		sb.append("Sum already gained : " + project.getGainedSum() + "<br>");
//		sb.append("Link to our project's video : " + project.getVideoLink() + "<br>");
//		sb.append("History  of our project : " + project.getProjectHistory() + "<br><br>");
//
//		for (Question q : questionDao.getProjectQuestions(project.getTitle())) {
//			sb.append(q.getQuestion() + "<br>");
//		}
//
//		sb.append(
//				"<br>You can ask your question here<br><html><head><title>QuestionSystem</title></head><body><form method =\"post\" action =\"QuestionServlet\">"
//						+ "<input type =\"hidden\" name = \"projectId\" value =" + "\"" + projectId
//						+ "\"/><input name =\"question\"/><input type = \"submit\" value = \"add question\"/></form></body></html><br>");
//		sb.append("<br><br><html><head><title>PaymentSystem</title></head><body><form action =\"PaymentServlet\">"
//				+ "<input type =\"hidden\" name = \"projectId\" value =" + "\"" + projectId
//				+ "\"/><input type =\"radio\" value =\"1\" name =\"paymentType\">Donate 50$</input><input type =\"radio\" value =\"2\" name =\"paymentType\">Donate 100$</input><input type =\"radio\" value =\"3\" name =\"paymentType\">Donate 150$</input><input type =\"radio\" value =\"4\" name =\"paymentType\">Donate random amount $</input><br><input type = \"submit\" value = \"payment type\"/></form></body></html><br>");
//
//		response.getWriter().append(sb);
	}

}
