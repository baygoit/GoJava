package ua.nenya.servlets;


import javax.servlet.http.HttpServlet;

import ua.nenya.main.DaoInitilizer;

public class CommonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private DaoInitilizer initilizer = new DaoInitilizer();
	
	public void init() {
		initilizer.initDao();
	}

	public DaoInitilizer getInitilizer() {
		return initilizer;
	}

}
