package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.DAO.dbStorage.mysql.PaymentDbStorage;
import ua.com.goit.gojava7.kickstarter.model.Payment;

@WebServlet("/payment")
public class PaymentController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	PaymentDbStorage paymentStorage;

	@Override
	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		String name = request.getParameter("inputName");
		Long cardNumber = Long.parseLong(request.getParameter("inputCardNumber"));
		int amount = Integer.parseInt(request.getParameter("inlineRadioOptions"));

		if (name != null && !name.isEmpty() && cardNumber != null && amount == 0) {
			amount = Integer.parseInt(request.getParameter("amount"));
		}
		if (name != null && !name.isEmpty() && cardNumber != null && amount > 0) {
			Payment payment = new Payment();
			payment.setIdParentProject(projectId);
			payment.setCardOwner(name);
			payment.setCardNumber(cardNumber);
			payment.setRechargeAmount(amount);
			paymentStorage.add(payment);
			response.sendRedirect("./project?id=" + projectId);

		}
	}

}
