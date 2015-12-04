package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.config.DataSource;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;

/**
 * Servlet implementation class Payment
 */
@WebServlet("/payment")
public class PaymentStuff extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PaymentDao paymentDao;
	private DaoProvider daoProvider;
	private int projectId;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentStuff() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		daoProvider = new DaoProvider(DataSource.MYSQL);
		
		daoProvider.open();
		
		paymentDao = daoProvider.getPaymentDao();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		projectId = Integer.parseInt(request.getParameter("id"));
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/payment.jsp");
		
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("first-name");
		
		long creditCardNumber = Long.parseLong(request.getParameter("creditCardNumber"));
		
		int donatingSum = Integer.parseInt(request.getParameter("donatingSum"));
	
		Payment payment = new Payment();
		
		payment.setProjectID(projectId);
		
		payment.setUserName(userName);
		
		payment.setCreditCardNumber(creditCardNumber);
		
		payment.setDonatingSum(donatingSum);
		
		paymentDao.add(payment);
		
		response.sendRedirect("/mykickstarter/project?id=" + projectId);
		
	}

}
