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

import ua.com.goit.gojava7.kickstarter.config.Validator;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDbDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDbDao;

@WebServlet("/paymentCheck")
public class PaymentCheckServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PaymentCheckServlet.class);	 
	
	@Autowired
	private ProjectDbDao projectDao;
	
	@Autowired
	private CategoryDbDao categoryDao;

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
		
		if (Validator.validateName(request.getParameter("name")) & Validator.validateCard(request.getParameter("card"))) {
			String name = request.getParameter("name");
			String card = request.getParameter("card");

			int pledgedOld = projectDao.get(projectId).getPledged();
			projectDao.updatePledged(projectDao.get(projectId), amount);
			int pledgedNew = projectDao.get(projectId).getPledged();			
			
			request.setAttribute("name", name);		
			request.setAttribute("pledgedOld", pledgedOld);
			request.setAttribute("pledgedNew", pledgedNew);	
			request.getRequestDispatcher("/WEB-INF/jsp/paymentOk.jsp").forward(request, response);

		} else {			
			request.setAttribute("message", "-----Wrong data-----");			
			request.getRequestDispatcher("/WEB-INF/jsp/payment.jsp").forward(request, response);		
		}		
	}
	
	//TODO check, controler, annotations, string in init
}
