package ua.com.goit.gojava2.vova.kickstarter.presenter;

public class MenuStatus {

	private int menuCategories;
	private int menuProjects;
	private int menuProject;
	private int menuPayment;
	private int menuQuestion;
	private int exit;

	public MenuStatus(){
		this.menuCategories = 222;
		this.menuProjects = 333;
		this.menuProject = 444;
		this.menuPayment = 555;
		this.menuQuestion = 666;
		this.exit = 999;
	}

	public int getMenuCategories() {
		return menuCategories;
	}

	public int getMenuProjects() {
		return menuProjects;
	}

	public int getMenuProject() {
		return menuProject;
	}

	public int getMenuPayment() {
		return menuPayment;
	}

	public int getMenuQuestion() {
		return menuQuestion;
	}

	public int getExit() {
		return exit;
	}

}
