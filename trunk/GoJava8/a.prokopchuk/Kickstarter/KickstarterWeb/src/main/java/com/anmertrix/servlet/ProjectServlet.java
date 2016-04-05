package com.anmertrix.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anmertrix.domain.Answer;
import com.anmertrix.domain.Project;
import com.anmertrix.domain.Question;

public class ProjectServlet extends Servlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String projectIdStr = request.getParameter("projectId");
		int projectId = 0;
		try {
			projectId = Integer.parseInt(projectIdStr);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		Project project = projectDao.getProjectById(projectId);
		List<Question> questions = projectDao.getQuestionByProjectId(projectId);
		
		for (Question question: questions) {
			List<Answer> answers = projectDao.getAnswerByQuestionId(question.getId());
			question.setAnswers(answers);
		}
		
        request.setAttribute("project", project);
        request.setAttribute("questions", questions);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/project.jsp");
        dispatcher.forward(request, response);
		
		
    }
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
		req.setCharacterEncoding("UTF-8");
		Question question = new Question();
		question.setQuestion(req.getParameter("question").trim());
		question.setProjectId(Integer.parseInt(req.getParameter("projectId")));
		projectDao.insertQuestion(question);
		resp.sendRedirect("project?projectId=" + question.getProjectId());
    }
}
