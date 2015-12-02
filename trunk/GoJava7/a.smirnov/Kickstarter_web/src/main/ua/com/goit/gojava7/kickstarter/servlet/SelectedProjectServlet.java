package main.ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.ua.com.goit.gojava7.kickstarter.beans.Faq;
import main.ua.com.goit.gojava7.kickstarter.beans.Project;
import main.ua.com.goit.gojava7.kickstarter.beans.Payment;
import main.ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import main.ua.com.goit.gojava7.kickstarter.config.DataSource;
import main.ua.com.goit.gojava7.kickstarter.dao.FaqDao;
import main.ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import main.ua.com.goit.gojava7.kickstarter.dao.ProjectDao;

@WebServlet(urlPatterns = "/project")
public class SelectedProjectServlet extends HttpServlet {
	private static final String SEPARATOR = "*********************************************************";
	private DaoProvider daoProvider;
	private ProjectDao projectDao;
	private FaqDao faqDao;
	private PaymentDao paymentDao;
	
	@Override
	public void init() throws ServletException {
		daoProvider = new DaoProvider(DataSource.MYSQL);
		daoProvider.open();
		projectDao = daoProvider.getProjectDao();
		faqDao = daoProvider.getFaqDao();
		paymentDao = daoProvider.getPaymentDao();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int selectedProjectId = Integer.parseInt(req.getParameter("id"));
		Project project = projectDao.getProjectById(selectedProjectId);
		List<Faq> faqs = faqDao.getProjectFaqs(selectedProjectId);
		int collectedSum = paymentDao.getSumProjectPayments(selectedProjectId);
		
		StringBuilder result = new StringBuilder().
			append("<html>").
				append("<head>").
					append("<title> Categories </title>").
				append("</head>").
				append("<body>").
					append("<a href=\"project?id=" + project.getUniqueID() + "\"> Title : " + project.getTitle() + "</a>").
					append("<br> Short description : " + project.getBriefDescription() + "</br>").
					append("<br> Full description : " + project.getFullDescription() + "</br>").
					append("<br> Required $ : " + project.getRequiredSum() + "</br>").
					append("<br> Collected $ : " + collectedSum + "</br>").
					append("<br> Video : " + project.getVideoLink() + "</br>").
					append("<br> Days left : " + project.getDaysLeft() + "</br>").
					append("<br> FAQ : </br>");
						for (Faq faq : faqs) {
							result.
								append("<p>").
									append("<br> question : " + faq.getQuestion() + "</br>").
									append("<br> answer : " + faq.getAnswer() + "</br>").
								append("</p>");
						}
					result.		
						append("<br><a href=\"pay?id=" + project.getUniqueID() + "\"> Donate money </a></br>").
					append("<br><a href=\"ask?id=" + project.getUniqueID() + "\"> Ask question </a></br>").
					append(SEPARATOR).
				append("</body>").
			append("</html>");
		resp.getWriter().append(result);
	}
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String activity = request.getParameter("operation");
        
        if (activity.equals("faq")) {
            processMessage(request, response);
        } 
        
        if (activity.equals("payment")) {
            processPayment(request, response);
        }
        
    }
	
	 private void processMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
	        int projectId = Integer.parseInt(request.getParameter("projectId"));
	        String question = request.getParameter("question");
	        
	        Faq faq = new Faq();
	        faq.setProjectID(projectId);
	        faq.setQuestion(question);
	        faqDao.add(faq);
	        
	        response.sendRedirect("project?id=" + projectId);
	 }
	 
	 private void processPayment(HttpServletRequest request, HttpServletResponse response) throws IOException {
	        int projectId = Integer.parseInt(request.getParameter("projectId"));
	        String username = request.getParameter("username");
	        long creditCardNumber = Long.parseLong(request.getParameter("creditCardNumber"));
	        int donatingSum = Integer.parseInt(request.getParameter("donatingSum"));
	        
	        Payment payment = new Payment();
	        payment.setProjectID(projectId);
	        payment.setUserName(username);
	        payment.setCreditCardNumber(creditCardNumber);
	        payment.setDonatingSum(donatingSum);
	        paymentDao.add(payment);
	        
	        response.sendRedirect("project?id=" + projectId);
	 }   

	@Override
	public void destroy() {
		daoProvider.close();
	}
}
