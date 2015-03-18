package ua.com.goit.gojava.solo307.intersim.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava.solo307.intersim.commons.StatisticsTraveler;
import ua.com.goit.gojava.solo307.intersim.domain.Assessor;
import ua.com.goit.gojava.solo307.intersim.domain.Interview;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String[] answers = request.getParameterValues("answer");
		StatisticsTraveler statisticsTraveler = Assessor.getStatisticsTraveler(answers);
		Interview interview = new Interview();
		interview.addStatistics(statisticsTraveler);
		request.setAttribute("traveler", statisticsTraveler);
		request.getRequestDispatcher("stats.jsp").forward(request, response);
	}
}
