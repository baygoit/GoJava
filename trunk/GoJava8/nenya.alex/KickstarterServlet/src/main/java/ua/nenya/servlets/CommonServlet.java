package ua.nenya.servlets;

import javax.servlet.http.HttpServlet;

import ua.nenya.main.DaoInitilizer;

//@WebServlet("/CommonServlet")
public class CommonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static final String ENTERING_MODE_ENV_NAME = "ENTERING_MODE";
	private String switcher = System.getenv(ENTERING_MODE_ENV_NAME);
	protected DaoInitilizer initilizer = new DaoInitilizer();
	
	public void init() {
		initilizer.initDao(switcher);
	}

}
