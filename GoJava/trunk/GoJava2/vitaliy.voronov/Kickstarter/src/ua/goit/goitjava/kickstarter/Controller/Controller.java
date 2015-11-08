package ua.goit.goitjava.kickstarter.Controller;

import ua.goit.goitjava.kickstarter.ConsoleIO;
import ua.goit.goitjava.kickstarter.Quote;
import ua.goit.goitjava.kickstarter.DB.CategoriesDAO;
import ua.goit.goitjava.kickstarter.DB.ProjectDAO;
import ua.goit.goitjava.kickstarter.model.Category;
import ua.goit.goitjava.kickstarter.model.Project;

public class Controller {
	
	private CategoriesDAO cat;
	private ProjectDAO projDao;
	private ConsoleIO consol; 
	private Project project = null;
	/*
	public Project getProject() {
		return project;
	}*/
	
	public Controller(CategoriesDAO cat, ProjectDAO projDao, ConsoleIO consol){
		this.cat=cat;
		this.projDao=projDao;
		this.consol=consol;
	}

	public void addMoney(int money){
		project.addMoney(money);
	}

	public void showProjectByCategory(int categoryId) {
		int i = 0;
		for(Project project: projDao.getListProjectByCategoryId(categoryId)){
			i++;
			String text = i + ") " + project.getName() + "\n "
					+ project.getDescription() + "\n We need - "
					+ project.getNeedMoney() + "$\n We have - "
					+ project.getHaveMoney() + "$\n Time over - "
					+ project.getDaysBeforeEnd() + " days";
			consol.print(text);
		}
		
	}
	
	public String getCategoriesString(){
		String categories = "";
		for(Category list: cat.getAllCategories()){
		categories += list.getName() + "\n";
		}
		return categories;
	}
	
	public void showSelectProject(int num, int categoryId) {
		project = projDao.getListProjectByCategoryId(categoryId).get(num - 1);
		String text = project.getName() + "\n " + project.getDescription()
				+ "\n We need - " + project.getNeedMoney() + "$\n We have - "
				+ project.getHaveMoney() + "$\n Time over - "
				+ project.getDaysBeforeEnd() + " days"
				+ project.getProjectHistory() + "\n "
				+ project.getLinkToDemoVideo();
		consol.print(text);
	}

	public void showAllCategories() {
		for (Category category : cat.getAllCategories()) {
			String text = category.getId() + " " + category.getName();
			consol.print(text);
		}
	}

	public void showCategoryByID(int id) {
		Category category = cat.getSelectCategory(id);
		String text = category.getName();
		consol.print(text);
	}

	public void updateProject() {
		projDao.updateProjectHaveMoney(project);		
	}
	
	public void showQuote() {
		Quote quote = new Quote();
		String text = quote.getLaoTzu();
		consol.print(text);
	}

	public void showZero(){
		String text = "0) Back one step";
		consol.print(text);
	}
	
	public void showGiftsMenu(){
		String text = "1 - 10$(you will get a thank)\n2 - 100$(you get a big thank)"
				+ "\n3 - 1000$(you get a very big thank)\n4 - 100000$(you get a Chupa Chups :) ";
		consol.print(text);
	}
	
	public int scanInt(){
		String text = consol.scan();
		int choice = Integer.parseInt(text);
		return choice;
	}
	
	public String scanString(){
		String text = consol.scan();
		return text;
	}
}