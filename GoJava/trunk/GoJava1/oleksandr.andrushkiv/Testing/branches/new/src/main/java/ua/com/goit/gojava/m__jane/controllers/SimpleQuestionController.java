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
		
//		System.out.println("delete " + request.getParameter("delete"));
//		System.out.println("enter " + request.getParameter("create"));
//		System.out.println("question_id " + request.getParameter("question_id"));
		//System.out.println(content);
		//System.out.println(standartAnswer);
		
	
								
		try {
			
			QuestionService questionService = new QuestionServiceImplDB();
			
			
			//update on questionPage.jsp
			if(request.getParameter("updateOne")!= null) {

				String question_id = request.getParameter("question_id");				
				if (question_id == null || "".equals(question_id)) throw new Exception("question_id is empty!");
				
				SimpleQuestion question = questionService.getQuestion(Integer.valueOf(question_id));
				if (question == null) throw new Exception("dont found question in DB with id= " + question_id);
				
				request.setAttribute("question", question);
				getServletContext().getRequestDispatcher("/questionUpdatePage.jsp").forward(
							request, response);
				return;
			}
			
			//update on questionUpdatePage.jsp
			if(request.getParameter("update")!= null) {

				String question_id = request.getParameter("question_id");
				String content = request.getParameter("question");
				String standartAnswer = request.getParameter("standartAnswer");
				
				if (question_id == null || "".equals(question_id)
						|| content == null || "".equals(content)
						|| standartAnswer == null || "".equals(standartAnswer))				
					throw new Exception("update fields are empty!");
				
				SimpleQuestion question = new SimpleQuestion();
				question.setId(Integer.valueOf(question_id));
				question.setContent(content);
				question.setStandartAnswer(standartAnswer);
				questionService.updateQuestion(question);							

			}
			
			
			if (request.getParameter("create")!= null) {
				String content = request.getParameter("question");
				String standartAnswer = request.getParameter("standartAnswer");
				
				if (content == null || "".equals(content)
						|| standartAnswer == null || "".equals(standartAnswer))				
					throw new Exception("fields are empty!");
				
				SimpleQuestion question = new SimpleQuestion();
				question.setContent(content);
				question.setStandartAnswer(standartAnswer);
				questionService.saveQuestion(question);
															
				
			} else if(request.getParameter("delete")!= null) {

				String question_id = request.getParameter("question_id");				
				if (question_id == null || "".equals(question_id)) throw new Exception("question_id is empty!");
				
				questionService.deleteQuestion(Integer.valueOf(question_id));
			}
			
						
			////			
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
