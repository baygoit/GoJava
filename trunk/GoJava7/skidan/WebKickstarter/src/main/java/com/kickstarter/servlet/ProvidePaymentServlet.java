package com.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kickstarter.dao.interfaces.DbProjectDaoImpl;
import com.kickstarter.model.Project;

@WebServlet("/ProvidePaymentServlet")
public class ProvidePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DbProjectDaoImpl projectDao;

	public void init() throws ServletException {
		projectDao = new DbProjectDaoImpl();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int projectId = Integer.parseInt(request.getParameter("projectId"));

		Integer paymentAmount = null;
		try {
			paymentAmount = Integer.parseInt(request.getParameter("paymentAmount"));
		} catch (NumberFormatException e) {
			
			response.sendRedirect("http://localhost:8080/WebKickstarter/SingleProjectServlet?projectId=" + projectId);
               return;
		}
		
		if(paymentAmount < 0){
			response.sendRedirect("http://localhost:8080/WebKickstarter/SingleProjectServlet?projectId=" + projectId);

		} else if(paymentAmount.equals(null)){
			response.sendRedirect("http://localhost:8080/WebKickstarter/SingleProjectServlet?projectId=" + projectId);
		}else{
		Project project = projectDao.getOne(projectId);
		int gainedSum = project.getGainedSum();
		project.setGainedSum(gainedSum + paymentAmount);
		projectDao.update(project);
		response.sendRedirect("http://localhost:8080/WebKickstarter/SingleProjectServlet?projectId=" + projectId);
	}
		
	
	}


}