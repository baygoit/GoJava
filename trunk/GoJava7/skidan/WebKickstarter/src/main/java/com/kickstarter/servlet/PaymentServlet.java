package com.kickstarter.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int projectId = Integer.parseInt(request.getParameter("projectId"));

		if (request.getParameter("paymentType").length() < 1) {
			response.sendRedirect("SingleProjectServlet?projectId=" + projectId);
			return;
		}
		// } else {
		int paymentType = Integer.parseInt(request.getParameter("paymentType"));
		int firstPaymentType = 50;
		int secondPaymentType = 100;
		int thirdPaymentType = 150;
		Integer tempPaymentType = null;
		String url = "/WEB-INF/Payment.jsp";
		request.setAttribute("projectId", projectId);

		switch (paymentType) {
		case 1:
			tempPaymentType = firstPaymentType;
			break;
		case 2:
			tempPaymentType = secondPaymentType;
			break;
		case 3:
			tempPaymentType = thirdPaymentType;
			break;
		default:
			url = "/WEB-INF/FullPayment.jsp";
			break;
		}

		request.setAttribute("paymentAmount", tempPaymentType);
		request.getRequestDispatcher(url).forward(request, response);
	}
}





//if (paymentType == 1) {
//tempPaymentType = firstPaymentType;
//
//} else if (paymentType == 2) {
//tempPaymentType = secondPaymentType;
//
//} else if (paymentType == 3) {
//tempPaymentType = thirdPaymentType;
//
//} else {
//url = "/WEB-INF/FullPayment.jsp";

//}
