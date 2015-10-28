package gojava;

import gojava.DAO.DAOCategories;
import gojava.DAO.DAOMenu;
import gojava.InFile.InFileCategories;
import gojava.InFile.InFileMenu;
import gojava.Interface.Categories;
import gojava.Interface.Menu;

public class Main {
	
	public static void main(String[] args) {
		
		Categories categories = new DAOCategories();
		ConsoleIO io = new ConsoleIO();
		InputCheck check = new InputCheck(io);
		Menu menu = new DAOMenu(categories, io, check);
		categories.fillCategories();
		
		Kickstarter kickstarter = new Kickstarter(io, menu);
		
		kickstarter.run();
	}
}
