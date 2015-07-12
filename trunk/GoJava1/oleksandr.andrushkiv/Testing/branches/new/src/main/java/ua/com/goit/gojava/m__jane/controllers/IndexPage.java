package ua.com.goit.gojava.m__jane.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava.m__jane.exceptions.TestingServiceException;
import ua.com.goit.gojava.m__jane.model.User;
import ua.com.goit.gojava.m__jane.service.UserService;
import ua.com.goit.gojava.m__jane.service.implXML.UserServiceImplXML;

/**
 * Servlet implementation class IndexPage
 */
public class IndexPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			UserService userService = new UserServiceImplXML();
						
			String paramLogin = request.getParameter("login");
			String paramPassw = request.getParameter("password");

			if (paramLogin == null || "".equals(paramLogin)
					|| paramPassw == null || "".equals(paramPassw))				
				throw new Exception("wrong login/password");
			
			
			User user = userService.checkUser(paramLogin, paramPassw);
			if (user!=null) {
				
				request.setAttribute("userDetailsMap", userService.getUserDetailsMap(user));
				getServletContext().getRequestDispatcher("/userQuizzes.jsp").forward(
						request, response);
			}else {
				request.setAttribute("userNotFound", "User not found! Enter again correctly!");
				getServletContext().getRequestDispatcher("/index.jsp").forward(
						request, response);
			}
		

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
