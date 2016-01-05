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

	@Autowired
	private Validator validator;

	@Override
	public void init() {
		log.info("Starting spring autowiring...");
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		log.info("Ended spring autowiring...");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		log.info("doPost()...");

		Integer amount = Integer.parseInt(request.getParameter("amount"));
		Long projectId = Long.parseLong(request.getParameter("projectId"));
		Long categoryId = projectDao.get(projectId).getCategory().getCategoryId();

		request.setAttribute("category", categoryDao.get(categoryId));
		request.setAttribute("project", projectDao.get(projectId));
		request.setAttribute("amount", amount);

		if (validator.validatePayment(request.getParameter("name"), request.getParameter("card"))) {
			Payment payment = new Payment(request.getParameter("name"), request.getParameter("card"), amount,
					projectDao.get(projectId));
			paymentDao.add(payment);
			request.getRequestDispatcher("/WEB-INF/jsp/paymentOk.jsp").forward(request, response);

		} else {
			request.setAttribute("message", "-----Wrong data-----");
			request.getRequestDispatcher("/WEB-INF/jsp/payment.jsp").forward(request, response);
		}
	}
}
