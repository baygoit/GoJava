package ua.com.goit.gojava.m__jane.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava.m__jane.exceptions.TestingServiceException;
import ua.com.goit.gojava.m__jane.model.Profile;
import ua.com.goit.gojava.m__jane.service.ProfileService;
import ua.com.goit.gojava.m__jane.service.implXML.ProfileServiceImplXML;

/**
 * Servlet implementation class SomeController1
 */
public class SomeController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SomeController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		try {
			ProfileService profileService = new ProfileServiceImplXML();
			List<Profile> profileList = profileService.getProfileList();
			request.setAttribute("profileList", profileList);
			getServletContext().getRequestDispatcher("/profiles.jsp").forward(request, response);
			
		} catch (TestingServiceException e) {
			request.setAttribute("errorDiscription", e.getMessage());
			getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("errorDiscription", e.getMessage());
			getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {

			String parameter = request.getParameter("profileId");
			if (parameter == null||"".equals(parameter)) 
				throw new Exception("wrong profileId");
			
			int profileId = Integer.valueOf(parameter);
		
			ProfileService profileService = new ProfileServiceImplXML();
			request.setAttribute("profileList", profileService.getProfileList());
			
			Profile profile = profileService.getProfile(profileId);
			request.setAttribute("quizList", profile.getQuizList());
			
			getServletContext().getRequestDispatcher("/profiles.jsp").forward(
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
