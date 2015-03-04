package ua.com.goit.gojava.m__jane.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava.m__jane.exceptions.TestingServiceException;
import ua.com.goit.gojava.m__jane.model.question.SimpleQuestion;
import ua.com.goit.gojava.m__jane.service.QuestionService;
import ua.com.goit.gojava.m__jane.service.implDB.QuestionServiceImplDB;


/**
 * Servlet implementation class SimpleQuestion
 */
public class SimpleQuestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleQuestionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			QuestionService questionService = new QuestionServiceImplDB();
						
			String content = request.getParameter("question");
			String standartAnswer = request.getParameter("standartAnswer");
			
System.out.println(content);
System.out.println(standartAnswer);
			
			if (content == null || "".equals(content)
					|| standartAnswer == null || "".equals(standartAnswer))				
				throw new Exception("fields empty");
			

			SimpleQuestion question = new SimpleQuestion();
			question.setContent(content);
			question.setStandartAnswer(standartAnswer);
			questionService.saveQuestion(question);
			
		
				
				request.setAttribute("questionList", questionService.getQuestionList());
				getServletContext().getRequestDispatcher("/questionPage.jsp").forward(
						request, response);
		

		} catch (TestingServiceException e) {
			request.setAttribute("errorDiscription", e.getMessage());
			getServletContext().getRequestDispatcher("/error.jsp").forward(
					request, response);
		} catch (Exception e) {
			request.setAttribute("errorDiscription", e.getMessage());
			getServletContext().getRequestDispatcher("/error.jsp").forward(
					request, response);
		}
	}

}
