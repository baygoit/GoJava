package ua.com.goit.gojava2.solo307.interview;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String[] answers = request.getParameterValues("answer");
		List<Mark> marks = Assessor.getMarks(answers);
		Interview interview = new Interview();
		long start = interview.readStartTime();
		String time = "";
		try {
			time = TimeCounter.getTime(start);
		} catch (InterviewSimulatorException e) {
			e.printStackTrace();
		}
		StatisticsDTO dto = new StatisticsDTO();
		dto.duration = time;
		dto.date = TimeCounter.getCurrentTime();
		dto.fillIncorrectAnswers(marks);
		dto.evaluateAnswers(dto, marks);
		interview.persistStatistics(dto);
		request.setAttribute("dto", dto);
		request.getRequestDispatcher("stats.jsp").forward(request, response);
	}
}
