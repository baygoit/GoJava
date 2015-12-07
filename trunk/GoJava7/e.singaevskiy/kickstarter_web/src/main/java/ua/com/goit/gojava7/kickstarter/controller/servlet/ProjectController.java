package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.dao.PaymentDAO;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;
import ua.com.goit.gojava7.kickstarter.dao.QuestionsDAO;
import ua.com.goit.gojava7.kickstarter.dao.StorageFactory;
import ua.com.goit.gojava7.kickstarter.domain.Payment;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;

@WebServlet("/project")
public class ProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private QuestionsDAO questionsDAO;
    private PaymentDAO paymentDAO;
    private ProjectDAO projectDAO;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int projectId = Integer.parseInt(request.getParameter("id"));
	    Project project = projectDAO.get(projectId);
	    project.setQuestions(questionsDAO.getByProject(projectId));
	    project.setBalanceSum(paymentDAO.getSum(projectId)); 
        
        request.setAttribute("project", project);
        request.getRequestDispatcher("view/ProjectDetails.jsp").forward(request, response);
	}
	
	@Override
    public void init() throws ServletException {
		StorageFactory factory = (StorageFactory) getServletContext().getAttribute(ContextInitializer.STORAGE_FACTORY);
        projectDAO = factory.getProjectDAO();
        paymentDAO = factory.getPaymentDAO();
        questionsDAO = factory.getQuestionsDAO();

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
        //String user = request.getParameter("user");
        String message = request.getParameter("message");
        
        questionsDAO.add(new Question(projectId, message, ""));
        
        response.sendRedirect("project?id=" + projectId);
    }

    private void processPayment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        String user = request.getParameter("user");
        int rewardId = Integer.parseInt(request.getParameter("rewardId"));
        long cardId = Long.parseLong(request.getParameter("cardId"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        
        Payment payment = new Payment(projectId, rewardId, user, cardId, amount, new Date(System.currentTimeMillis()));
        paymentDAO.add(payment);
        
        response.sendRedirect("project?id=" + projectId);
    }   
}
