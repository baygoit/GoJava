package ua.com.goit.gojava.solo307.interview.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava.solo307.interview.domain.Interview;
import ua.com.goit.gojava.solo307.interview.utils.Assessor;
import ua.com.goit.gojava.solo307.interview.utils.StatisticsDTO;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		response.setContentType("text/html;charset=utf-8");
		String[] answers = request.getParameterValues("answer");
		StatisticsDTO statisticsDTO = Assessor.getStatisticsDTO(answers);
		Interview interview = new Interview();
		interview.addStatistics(statisticsDTO);
		request.setAttribute("dto", statisticsDTO);
		request.getRequestDispatcher("stats.jsp").forward(request, response);
	}
}
