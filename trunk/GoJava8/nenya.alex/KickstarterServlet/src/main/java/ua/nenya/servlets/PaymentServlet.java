package ua.nenya.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nenya.domain.Payment;
import ua.nenya.domain.Project;
import ua.nenya.domain.Reward;

public class PaymentServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String projectId = request.getParameter("projectId");
		Long proId = 0L;
		try {
			proId = Long.parseLong(projectId);
		} catch (NumberFormatException e) {
			request.setAttribute("Id", projectId);
			request.setAttribute("TestId", -1);
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		request.setAttribute("projectId", proId);
		
		if(!projectDao.isProjectExist(proId)){
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		Project project = projectDao.getProjectByProjectId(proId);
		request.setAttribute("project", project);

		List<Reward> rewards = rewardDao.getRewards(proId);
		request.setAttribute("rewards", rewards);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/payment.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String amountString = request.getParameter("amount");
		String projectId = request.getParameter("projectId");
		Long proId = 0L;
		try {
			proId = Long.parseLong(projectId);
		} catch (NumberFormatException e) {
			request.setAttribute("Id", projectId);
			request.setAttribute("TestId", -1);
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		if ("0".equals(amountString)) {
			String investmentString = request.getParameter("investment");
			int investment = 0;
			try{
			investment = Integer.parseInt(investmentString);
			}catch(NumberFormatException e){
				request.setAttribute("investment", -1);
				response.sendError(HttpServletResponse.SC_BAD_REQUEST);
				return;
			}
			paymentDao.writePaymentInProject(createPayment(proId, investment));
		} else {
			paymentDao.writePaymentInProject(createPayment(proId, Integer.parseInt(amountString)));
		}

		response.sendRedirect("projectServlet?projectId=" + proId);
	}

	private Payment createPayment(Long proId, int investment) {
		Payment payment = new Payment();
		payment.setAmount(investment);
		payment.setProject(projectDao.getProjectByProjectId(proId));
		return payment;
	}

}
