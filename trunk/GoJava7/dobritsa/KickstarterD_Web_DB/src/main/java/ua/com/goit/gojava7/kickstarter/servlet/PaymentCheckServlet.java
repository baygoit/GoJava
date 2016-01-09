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

import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.models.Project;

@WebServlet("/paymentCheck")
public class PaymentCheckServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PaymentCheckServlet.class);

	@Autowired
	private ProjectDao projectDao;

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

		Long projectId = Long.parseLong(request.getParameter("projectId"));
		Long amount = Long.parseLong(request.getParameter("amount"));
		String name = request.getParameter("name");
		String card = request.getParameter("card");

		Project project = projectDao.get(projectId);

		request.setAttribute("category", projectDao.getCategory(project));
		request.setAttribute("project", project);
		request.setAttribute("amount", amount);

		if (paymentDao.createPayment(name, card, amount, project))
			request.getRequestDispatcher("/WEB-INF/jsp/paymentOk.jsp").forward(request, response);

		request.setAttribute("message", "-----Wrong data-----");
		request.getRequestDispatcher("/WEB-INF/jsp/payment.jsp").forward(request, response);
	}
}
