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
			response.sendRedirect("http://localhost:8080/WebKickstarter/SingleProjectServlet?projectId=" + projectId);
		} else {
			int paymentType = Integer.parseInt(request.getParameter("paymentType"));
			int first = 50;
			int second = 100;
			int third = 150;
			if (paymentType == 1) {
				request.setAttribute("paymentAmount", first);
				request.setAttribute("projectId", projectId);
				request.getRequestDispatcher("/WEB-INF/Payment.jsp").forward(request, response);
//				response.getWriter()
//						.append("<br><br><html><head><title>QuestionSystem</title></head><body><form method =\"post\" action =\"ProvidePaymentServlet\">"
//								+ "<input type =\"hidden\" name = \"projectId\" value =" + "\"" + projectId
//								+ "\"/><input type =\"hidden\" name =\"paymentAmount\" value =" + "\"" + first
//								+ "\"/><input name =\"payerName\" value = \"Card Holder Name\"/><br><br><input name =\"cardNumber\" value = \"Card Number\"/><br><br><input type = \"submit\" value = \"approve payment\"/></form></body></html><br>");
			} else if (paymentType == 2) {
				request.setAttribute("paymentAmount", second);
				request.setAttribute("projectId", projectId);
				request.getRequestDispatcher("/WEB-INF/Payment.jsp").forward(request, response);
//				response.getWriter()
//						.append("<br><br><html><head><title>QuestionSystem</title></head><body><form method =\"post\" action =\"ProvidePaymentServlet\">"
//								+ "<input type =\"hidden\" name = \"projectId\" value =" + "\"" + projectId
//								+ "\"/><input type =\"hidden\" name =\"paymentAmount\" value =" + "\"" + second
//								+ "\"/><input name =\"payerName\" value = \"Card Holder Name\"/><br><br><input name =\"cardNumber\" value = \"Card Number\"/><br><br><input type = \"submit\" value = \"approve payment\"/></form></body></html><br>");

			} else if (paymentType == 3) {
				request.setAttribute("paymentAmount", third);
				request.setAttribute("projectId", projectId);
				request.getRequestDispatcher("/WEB-INF/Payment.jsp").forward(request, response);
//				response.getWriter()
//						.append("<br><br><html><head><title>QuestionSystem</title></head><body><form method =\"post\" action =\"ProvidePaymentServlet\">"
//								+ "<input type =\"hidden\" name = \"projectId\" value =" + "\"" + projectId
//								+ "\"/><input type =\"hidden\" name =\"paymentAmount\" value =" + "\"" + third
//								+ "\"/><input name =\"payerName\" value = \"Card Holder Name\"/><br><br><input name =\"cardNumber\" value = \"Card Number\"/><br><br><input type = \"submit\" value = \"approve payment\"/></form></body></html><br>");

			} else {
				request.setAttribute("projectId", projectId);
				request.getRequestDispatcher("/WEB-INF/FullPayment.jsp").forward(request, response);
				
//				response.getWriter()
//						.append("<br><br><html><head><title>QuestionSystem</title></head><body><form method =\"post\" action =\"ProvidePaymentServlet\">"
//								+ "<input type =\"hidden\" name = \"projectId\" value =" + "\"" + projectId
//								+ "\"/><input name =\"paymentAmount\" value = \"Amount of Payment\"/><br><br><input name =\"payerName\" value = \"Card Holder Name\"/><br><br><input name =\"cardNumber\" value = \"Card Number\"/><br><br><input type = \"submit\" value = \"approve  payment\"/></form></body></html><br>");

			}

		}

	}
}
