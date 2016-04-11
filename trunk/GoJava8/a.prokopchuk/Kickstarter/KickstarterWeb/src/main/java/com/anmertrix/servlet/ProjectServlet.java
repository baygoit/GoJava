package com.anmertrix.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.anmertrix.dao.NoResultException;
import com.anmertrix.dao.ProjectDao;
import com.anmertrix.dao.RewardDao;
import com.anmertrix.domain.Answer;
import com.anmertrix.domain.Payment;
import com.anmertrix.domain.Project;
import com.anmertrix.domain.Question;
import com.anmertrix.domain.Reward;

public class ProjectServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String ADD_QUESTION = "ADD_QUESTION";
	private static final String ADD_PAYMENT = "ADD_PAYMENT";
	
	@Autowired
	protected ProjectDao projectDao;
	@Autowired
	protected RewardDao rewardDao;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Project project = getSelectedProject(request, response);
		
		List<Question> questions = projectDao.getQuestionsByProjectId(project.getId());
		
		for (Question question: questions) {
			List<Answer> answers = projectDao.getAnswersByQuestionId(question.getId());
			question.setAnswers(answers);
		}
		
		List<Payment> payments = projectDao.getPaymentsByProjectId(project.getId());
		List<Reward> rewards = rewardDao.getRewards();
		
        request.setAttribute("project", project);
        request.setAttribute("questions", questions);
        request.setAttribute("payments", payments);
        request.setAttribute("rewards", rewards);
        
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/project.jsp").forward(request, response);
		
		
    }
	
	public Project getSelectedProject(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String projectIdStr = request.getParameter("projectId");
		int projectId = 0;
		try {
			projectId = Integer.parseInt(projectIdStr);
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			
			return null;
		}
		
		try {
			projectDao.projectExists(projectId);
			return projectDao.getProjectById(projectId);
		} catch (NoResultException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String requestedAction = request.getParameter("requested_action");
		
		if (ADD_QUESTION.equals(requestedAction)) {
			addQuestion(request, response);
		} else if (ADD_PAYMENT.equals(requestedAction)) {
			addPayment(request, response);
		}

	}
	
	void addQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		Question question = new Question();
		question.setQuestion(request.getParameter("question").trim());
		question.setProjectId(Integer.parseInt(request.getParameter("projectId")));
		projectDao.insertQuestion(question);
		response.sendRedirect("project?projectId=" + question.getProjectId());
	}
	
	void addPayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		
		Payment payment = new Payment();
		payment.setCardholderName(request.getParameter("cardholder_name").trim());
		payment.setCardNumber(request.getParameter("card_number").trim());
		payment.setAmount(Integer.parseInt(request.getParameter("payment_amount").trim()));
		payment.setProjectId(Integer.parseInt(request.getParameter("projectId")));
		projectDao.insertPayment(payment);
		response.sendRedirect("project?projectId=" + payment.getProjectId());
	}
	
	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
}
