package ua.nenya.servlets;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import ua.nenya.main.DaoInitilizer;
import ua.nenya.project.Category;

public class CommonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected DaoInitilizer initilizer = new DaoInitilizer();
	protected List<Category> categories = new ArrayList<>();
	
	public void init() {
		initilizer.initDao();
		categories = initilizer.getCategoryDao().initCategories();
	}

}
