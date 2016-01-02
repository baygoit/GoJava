package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.dao.PaymentDAO;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;
import ua.com.goit.gojava7.kickstarter.dao.QuestionsDAO;
import ua.com.goit.gojava7.kickstarter.dao.RewardDAO;
import ua.com.goit.gojava7.kickstarter.domain.Payment;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;

@WebServlet("/project")
public class ProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
    private QuestionsDAO questionsDAO;
	@Autowired
    private PaymentDAO paymentDAO;
	@Autowired
    private ProjectDAO projectDAO;
	@Autowired
    private RewardDAO rewardDAO;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int projectId = Integer.parseInt(request.getParameter("id"));
	    Project project = projectDAO.get(projectId);
	    project.setQuestions(questionsDAO.getByProject(projectId));
	    project.setBalanceSum(paymentDAO.getSum(projectId)); 
        
        request.setAttribute("project", project);
        request.setAttribute("rewards", rewardDAO.getByProject(projectId));
        request.getRequestDispatcher("view/ProjectDetails.jsp").forward(request, response);
	}
	
	@Override
    public void init() throws ServletException {
    	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String operation = request.getParameter("operation");
        if (operation == null) {
            
        } else if (operation.equals("message")) {
            processMessage(request, response);
        } else if (operation.equals("payment")) {
            processPayment(request, response);
        }
        
    }

    private void processMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        String user = request.getParameter("user");
        String message = request.getParameter("message");
        
        Map<String, String> validationErrors = validateMessage(user, message);   	
    	
    	if (validationErrors.isEmpty()) {       
    		questionsDAO.add(new Question(projectDAO.get(projectId), message, ""));
    		response.sendRedirect("project?id=" + projectId);
    	} else {
    		request.getSession(false).setAttribute("errors", validationErrors);
	    	response.sendRedirect("message?id="+projectId);
    	}        
        
    }

    private void processPayment(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	
    	String projectId = request.getParameter("projectId");
    	String user = request.getParameter("user");
    	String rewardId = request.getParameter("rewardId");
    	String cardId = request.getParameter("cardId");
    	String amount = request.getParameter("amount");
    	
    	System.out.println(projectId);
    	System.out.println(rewardId);
    	
    	Map<String, String> validationErrors = validatePayment(user, cardId, amount);   	
    	
    	if (validationErrors.isEmpty()) {
    		Payment payment = new Payment(projectDAO.get(Integer.parseInt(projectId)), 
            		rewardDAO.get(Integer.parseInt(rewardId)), 
            		user, 
            		Long.parseLong(cardId), 
            		Integer.parseInt(amount), 
            		new Date(System.currentTimeMillis()));
            paymentDAO.add(payment);           
            response.sendRedirect("project?id=" + projectId);
		} else {
	    	request.getSession(false).setAttribute("errors", validationErrors);
	    	response.sendRedirect("payment?projectId="+projectId+"&rewardId="+rewardId+"&amount=" + amount);
		}
       
    }

	private Map<String, String> validatePayment(String user, String cardId, String amount) {
		Map<String, String> validationErrors = new HashMap<>();
		int nameLength = 3;
		if (user.length() < nameLength) {
			validationErrors.put("user", "User name must have at least " + nameLength + " characters length");
		}
		int cardLength = 9;
		if (!cardId.matches("[0-9]{" + cardLength + "}")) {
			validationErrors.put("cardId", "Card ID must be positive numeric and have at least " + cardLength + " characters length");
		}
		if (!amount.matches("[0-9]+") || Integer.valueOf(amount) <= 0) {
			validationErrors.put("amount", "Amount must be positive numeric");
		}
		return validationErrors;
	}  
	
	private Map<String, String> validateMessage(String user, String message) {
		Map<String, String> validationErrors = new HashMap<>();
		int nameLength = 3;
		if (user.length() < nameLength) {
			validationErrors.put("user", "User name must have at least " + nameLength + " characters length");
		}
		int messageLength = 10;
		if (message.length() < messageLength) {
			validationErrors.put("message", "Message text must have at least " + messageLength + " characters length");
		}

		return validationErrors;
	} 
}
