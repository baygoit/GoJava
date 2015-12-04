package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.controller.servlet.util.HtmlPageWriter;
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
	    
        StringBuilder body = new StringBuilder();
        body.append("<b>" + project.getName() + "</b>");
        body.append("\n<i>Author: " + project.getAuthor() + "</i>");
        body.append("\n\n" + project.getDescription());
        body.append("\nGoal: " + project.getGoalSum());
        body.append(" / Balance: " + project.getBalanceSum());
        body.append("\nStarted:" + project.getEndDate());
        body.append("\nDays left: " + project.daysLeft());
        
        body.append("\n\n<iframe width=\"420\" height=\"315\""
                + "src=\"http://www.youtube.com/embed/" 
                + project.getVideoUrl().substring(project.getVideoUrl().lastIndexOf("=")+1)
                +"?autoplay=0\">"
                + "</iframe>\n");
        
        if (!project.getQuestions().isEmpty()) {
            body.append("\nFAQ:");
            project.getQuestions().stream().map(faq -> "\n" + faq.getQuestion() + " : " + faq.getAnswer())
                    .forEach(body::append);
        }

        body.append("\n1. <a href=message?id=" + project.getId() + ">Send message</a>");
        body.append("\n2. <a href=pay?id=" + project.getId() + ">Pay</a>");

        HtmlPageWriter htmlPageWriter = new HtmlPageWriter();
        htmlPageWriter.setTitle(project.getName());
        htmlPageWriter.setBody(body.toString());

        response.getWriter().print(htmlPageWriter.prepare());
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
