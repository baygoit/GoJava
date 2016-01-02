package com.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.kickstarter.dao.interfaces.ProjectDaoImpl;
import com.kickstarter.dao.interfaces.PaymentDaoImpl;
import com.kickstarter.model.Project;

@WebServlet("/ProvidePaymentServlet")
public class ProvidePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	PaymentDaoImpl paymentDao;
	@Autowired
	ProjectDaoImpl projectDao;

	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		Integer paymentAmount = null;
		try {
			paymentAmount = Integer.parseInt(request.getParameter("paymentAmount"));
		} catch (NumberFormatException e) {
			response.sendRedirect("SingleProjectServlet?projectId=" + projectId);
			return;
		}
		if (paymentAmount < 0) {
			response.sendRedirect("SingleProjectServlet?projectId=" + projectId);
		} else if (paymentAmount.equals(null)) {
			response.sendRedirect("SingleProjectServlet?projectId=" + projectId);
		} else {
			Project project = projectDao.getOne(projectId);
			paymentDao.addPayment(project, paymentAmount);
			response.sendRedirect("SingleProjectServlet?projectId=" + projectId);
		}

	}

}