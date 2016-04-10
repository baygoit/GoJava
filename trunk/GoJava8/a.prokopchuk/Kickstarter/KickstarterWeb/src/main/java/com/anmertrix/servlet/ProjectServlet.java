package com.anmertrix.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anmertrix.dao.NoResultException;
import com.anmertrix.domain.Answer;
import com.anmertrix.domain.Payment;
import com.anmertrix.domain.Project;
import com.anmertrix.domain.Question;
import com.anmertrix.domain.Reward;

public class ProjectServlet extends Servlet {

	private static final long serialVersionUID = 1L;
	private static final String ADD_QUESTION = "ADD_QUESTION";
	private static final String ADD_PAYMENT = "ADD_PAYMENT";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String projectIdStr = request.getParameter("projectId");
		int projectId = 0;
		try {
			projectId = Integer.parseInt(projectIdStr);
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		Project project = null;
		try {
			project = projectDao.getProjectById(projectId);
		} catch (NoResultException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		List<Question> questions = projectDao.getQuestionByProjectId(projectId);
		
		for (Question question: questions) {
			List<Answer> answers = projectDao.getAnswerByQuestionId(question.getId());
			question.setAnswers(answers);
		}
		
		List<Payment> payments = projectDao.getPaymentsByProjectId(projectId);
		List<Reward> rewards = projectDao.getRewards();
		
        request.setAttribute("project", project);
        request.setAttribute("questions", questions);
        request.setAttribute("payments", payments);
        request.setAttribute("rewards", rewards);
        
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/project.jsp").forward(request, response);
		
		
    }
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String requestedAction = req.getParameter("requested_action");
		
		if (ADD_QUESTION.equals(requestedAction)) {
			addQuestion(req, resp);
		} else if (ADD_PAYMENT.equals(requestedAction)) {
			addPayment(req, resp);
		}

	}
	
	
	
	private void addQuestion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		Question question = new Question();
		question.setQuestion(req.getParameter("question").trim());
		question.setProjectId(Integer.parseInt(req.getParameter("projectId")));
		projectDao.insertQuestion(question);
		resp.sendRedirect("project?projectId=" + question.getProjectId());
	}
	
	private void addPayment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		
		Payment payment = new Payment();
		payment.setCardholderName(req.getParameter("cardholder_name").trim());
		payment.setCardNumber(req.getParameter("card_number").trim());
		payment.setAmount(Integer.parseInt(req.getParameter("payment_amount").trim()));
		payment.setProjectId(Integer.parseInt(req.getParameter("projectId")));
		projectDao.insertPayment(payment);
		resp.sendRedirect("project?projectId=" + payment.getProjectId());
	}
}
