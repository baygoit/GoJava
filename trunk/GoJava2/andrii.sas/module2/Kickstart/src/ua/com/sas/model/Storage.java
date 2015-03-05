package ua.com.sas.model;

import ua.com.sas.controller.Kickstart;
import ua.com.sas.view.*;

public class Storage {
	private Categories categories;
	private Projects projects;
	private Kickstart kickstart;
	private View view;
	private ConnectionDAO connectionDAO;
	
	
	public Storage(Output output, Input input, Quote quote){
		connectionDAO = new ConnectionDAO("kickstarter_db", "postgres", "gfhfien17");
		categories = new CategoriesDAO(connectionDAO);
		projects = new ProjectsDAO(connectionDAO);
		view = new View(output);
		kickstart = new Kickstart(view, input, categories, projects, quote);
	}
	public void initiate(){
		kickstart.buildMenu();
		connectionDAO.closeConnection();
	}
}
