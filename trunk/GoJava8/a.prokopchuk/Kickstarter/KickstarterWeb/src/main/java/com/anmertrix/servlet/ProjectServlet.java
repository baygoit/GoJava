package com.anmertrix.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.anmertrix.dao.AnswerDao;
import com.anmertrix.dao.NoResultException;
import com.anmertrix.dao.PaymentDao;
import com.anmertrix.dao.ProjectDao;
import com.anmertrix.dao.QuestionDao;
import com.anmertrix.domain.Payment;
import com.anmertrix.domain.Project;
import com.anmertrix.domain.Question;

public class ProjectServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String ADD_QUESTION = "ADD_QUESTION";
	private static final String ADD_PAYMENT = "ADD_PAYMENT";
	private static final String PROJECT_OUT_URL = "project?projectId=";
	private static final String PROJECT_JSP_PATH = "/WEB-INF/jsp/project.jsp";
	
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private PaymentDao paymentDao;
	@Autowired
	private AnswerDao answerDao;
	@Autowired
	private QuestionDao questionDao;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Project project = getSelectedProject(request, response);
		if (project == null) {
			return;
		}
		LocalDate finalDate = project.getFinalDate().toLocalDate();
		LocalDate today = LocalDate.now();
		if (today.isBefore(finalDate)) {
			project.setDaysLeft((int) ChronoUnit.DAYS.between(today, finalDate));
		}
		
		request.setAttribute("project", project);
		getServletContext().getRequestDispatcher(PROJECT_JSP_PATH).forward(request, response);
	}
	
	public Project getSelectedProject(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			if (!validateProjectId(request, response)) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				return null;
			}
			return projectDao.getProjectById(Long.parseLong(request.getParameter("projectId")));
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String requestedAction = request.getParameter("requested_action");
		if (ADD_QUESTION.equals(requestedAction)) {
			addQuestion(request, response);
		} else if (ADD_PAYMENT.equals(requestedAction)) {
			addPayment(request, response);
		}
	}
	
	void addQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			if (!validateQuestion(request, response)) {
				throw new NumberFormatException();
			} else if (!validateProjectId(request, response)) {
				throw new NoResultException("No project found");
			}
			long projectId = Long.parseLong(request.getParameter("projectId"));
			Project project = projectDao.getProjectById(projectId);
			Question question = new Question();
			question.setQuestion(request.getParameter("question").trim().replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;"));
			question.setProject(project);
			questionDao.insertQuestion(question);
			response.sendRedirect(PROJECT_OUT_URL + projectId);
		} catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        } catch (NoResultException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}
	
	private boolean validateQuestion(HttpServletRequest request,
			HttpServletResponse response) {
		String question = request.getParameter("question").trim().replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
		if (question.length() < 2 || question.length() > 500) {
			return false;
		}
		return true;
	}

	void addPayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			if (!validateCardholderName(request, response) 
					|| !validateCardNumber(request, response) 
					|| !validateAmount(request, response)) {
				throw new NumberFormatException();
			} else if (!validateProjectId(request, response)) {
				throw new NoResultException("No project found");
			}
			long projectId = Long.parseLong(request.getParameter("projectId"));
			Project project = projectDao.getProjectById(projectId);
			Payment payment = new Payment();
			payment.setCardholderName(request.getParameter("cardholder_name").trim().replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;"));
			payment.setCardNumber(request.getParameter("card_number").trim());
			payment.setAmount(Integer.parseInt(request.getParameter("payment_amount").trim()));
			payment.setProject(project);
			paymentDao.insertPayment(payment);
			response.sendRedirect(PROJECT_OUT_URL + projectId);
		} catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        } catch (NoResultException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}
	
	private boolean validateCardholderName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cardholderName = request.getParameter("cardholder_name").trim().replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
		if (cardholderName.length() < 2 || cardholderName.length() > 50) {
			return false;
		}
		return true;
	}
	
	private boolean validateCardNumber(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cardNumber = request.getParameter("card_number").trim();
		if (cardNumber.length() < 13 || cardNumber.length() > 16 || !cardNumber.matches("^-?\\d+$")) {
			return false;
		}
		return true;
	}
	
	private boolean validateAmount(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException {
		int amount = Integer.parseInt(request.getParameter("payment_amount").trim());
		if (amount <= 0 || amount > 1000000) {
			return false;
		}
		return true;
	}
	
	private boolean validateProjectId(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException {
		long projectId = Long.parseLong(request.getParameter("projectId"));
		return projectDao.projectExists(projectId);
	}

	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
}
