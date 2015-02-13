package ua.com.goit.gojava.m__jane.controllers;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava.m__jane.exceptions.TestingServiceException;
import ua.com.goit.gojava.m__jane.service.ProfileService;
import ua.com.goit.gojava.m__jane.service.impl.ProfileServiceImpl;

/**
 * Servlet implementation class SomeController1
 */
public class SomeController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ProfileService profileService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SomeController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {

		try {
			profileService = new ProfileServiceImpl();
		} catch (TestingServiceException e) {
			req.setAttribute("errorDiscription", "service error");
			getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);

		}
	}
	
}
