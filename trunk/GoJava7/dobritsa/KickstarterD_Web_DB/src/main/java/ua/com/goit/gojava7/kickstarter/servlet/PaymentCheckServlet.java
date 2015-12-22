package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.models.Payment;

@WebServlet("/paymentCheck")
public class PaymentCheckServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PaymentCheckServlet.class);	 
	
	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private PaymentDao paymentDao;	

	@Override
	public void init() {
		log.info("Starting spring autowiring...");
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);	
		log.info("Ended spring autowiring...");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		log.info("doPost()...");		
		int amount = Integer.parseInt(request.getParameter("amount"));
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		
		request.setAttribute("category", categoryDao.get(projectDao.get(projectId).getCategoryId()));
		request.setAttribute("project", projectDao.get(projectId));
		request.setAttribute("amount", amount);
		
		if (true) {
				//Validator.validateName(request.getParameter("name")) & Validator.validateCard(request.getParameter("card"))) {
			
			Payment payment = new Payment();
			payment.setUser(request.getParameter("name"));
			payment.setCard(request.getParameter("card"));
			payment.setAmount(amount);
			payment.setProjectId(projectId);
			paymentDao.add(payment);
			
		//	String name = request.getParameter("name");
		//	String card = request.getParameter("card");

		//	int pledgedOld = projectDao.get(projectId).getPledged();
		//	projectDao.updatePledged(projectDao.get(projectId), amount);
		//	int pledgedNew = projectDao.get(projectId).getPledged();			
						
			request.getRequestDispatcher("/WEB-INF/jsp/paymentOk.jsp").forward(request, response);

		} else {			
			request.setAttribute("message", "-----Wrong data-----");			
			request.getRequestDispatcher("/WEB-INF/jsp/payment.jsp").forward(request, response);		
		}		
	}
}
