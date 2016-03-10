package ua.kutsenko.KickstarterGoIt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Category implements Writer {

	private String name;
	private List<Category> categoriesList = new ArrayList<Category>();
	private List<Project> projectList = new ArrayList<Project>();
	private Project project = new Project();
	private int selector;
	private Category category;
	private Kickstarter kick;
	private Category categoryR;

	public Category(String name, List<Project> projectList) {
		this.name = name;
		this.projectList = projectList;
	}

	public Category() {

	}

	public int getSelector() {
		return selector;
	}

	public String getName() {
		return name;
	}

	public List<Project> getProjectList() {

		return this.projectList;
	}

	public void showCategory() {

		for (int i = 0; i < categoriesList.size(); i++) {
			write(i + 1 + "-" + categoriesList.get(i).name);
		}
	}

	public void initCategory() {
		categoriesList.add(new Category("It", project.getItProjectList()));
		categoriesList.add(new Category("Films", project.getFilmsProjectList()));
		categoriesList.add(new Category("Music", project.getMusicProjectList()));
	}

	public void showProjects(Category selectedCategory) {
		for (int i = 0; i < selectedCategory.projectList.size(); i++) {
			Project project = selectedCategory.projectList.get(i);
			write(i + 1 + " - ");
			printProject(project);
		}

	}

	private void printProject(Project project) {
		write("Name project - " + project.getName());
		write("Description project - " + project.getDecription());
		write("Required budget - " + project.getRequiredBudget() + "$");
		write("Gathered budget - " + project.getGatheredBudget() + "$");
		write("days to go project - " + project.getDaysLeft());
		write("--------------------");

	}

	public void printProjectInfo(Project project) {
		write("History project - " + project.getHistoryProject());
		write("url to video - " + project.getUrlToVideo());
		write("Question and answer - " + project.getqA());
		write("");

	}

	public Category selectCategory() {
		write("Select category, 0 to exit :");
		Scanner sc = new Scanner(System.in);
		selector = sc.nextInt();
		if (selector == 0) {
			endApp(selector);
		}
		if (selector < 0 || categoriesList.size() < selector) {
			write("Неверный индекс меню - " + selector);
			System.out.println();
			showCategory();
			category = selectCategory();
		}
		category = categoriesList.get(selector - 1);
		write("You selelect: " + category.getName());

		return category;
	}


	public Project selectProject(Category selectedCategory) {
		write("Select project, 0 to exit, 9 back to category  ");
		Scanner sc = new Scanner(System.in);
		selector = sc.nextInt();
		Project selectProjects = null;
		if (selector == 0) {
			endApp(selector);
		}
		if (selector == 9) {
			showCategory();
			categoryR = selectCategory();
			category.showProjects(categoryR);		
		
			}
		if (selector < 0 || selectedCategory.getProjectList().size() < selector) {
			write("Неверный индекс меню - " + selector);
			Project selectProject = selectProject(selectedCategory);
		}

		Project selectProject = selectedCategory.projectList.get(selector - 1);
		printProject(selectProject);
		printProjectInfo(selectProject);
		selectProjects = selectProject; 
		return selectProject;//}
	
		
		
		  }
		

	public Project actionProject(Project selectProject, Category selectedCategory) {
		write("8 invest project , 9 back to category ," + " 7 Ask question");
		Scanner sc = new Scanner(System.in);
		selector = sc.nextInt();
		if (selector == 8) {
			invest(selectProject, selectedCategory);
		}
		if (selector == 9) {
			// write("press any key");
			// category = selectCategory();
		}
		if (selector == 7) {
			askQuestion(selectProject, selectedCategory);
		}
		return selectProject;
	}

	private void askQuestion(Project projectIn, Category selectedCategory) {
		Scanner sc = new Scanner(System.in);
		write("Enter you question");
		String question = sc.nextLine();
		projectIn.setqA(question);
		Project selectProject = projectIn;
		printProject(selectProject);
		printProjectInfo(selectProject);

	}

	private void endApp(int selector2) {
		write("goodbye !");
		System.exit(selector2);

	}

	private void invest(Project projectIn, Category selectedCategory) {
		write("Select pay: 1 quick , 2 card");
		Scanner sc = new Scanner(System.in);
		int pay = sc.nextInt();
		if (pay == 2) {
			write("Enter you inputting card holder");
			String cardHolder = sc.nextLine();
			write("Enter you name card");
			String nameCard = sc.nextLine();
			write("Enter you invest mooney: ");
			int plus = sc.nextInt();
			projectIn.setGatheredBudget(projectIn.getGatheredBudget(), plus);
			Project selectProject = projectIn;
			printProject(selectProject);
			printProjectInfo(selectProject);
		}
		if (pay == 1) {
			write("1 - 100$, 2 - 200$, 3 - 50$");
			int hotSum = sc.nextInt();
			if (hotSum == 1) {
				projectIn.setGatheredBudget(projectIn.getGatheredBudget(), 100);
				Project selectProject = projectIn;
				printProject(selectProject);
				printProjectInfo(selectProject);
			}
			if (hotSum == 2) {
				projectIn.setGatheredBudget(projectIn.getGatheredBudget(), 200);
				Project selectProject = projectIn;
				printProject(selectProject);
				printProjectInfo(selectProject);
			}
			if (hotSum == 3) {
				projectIn.setGatheredBudget(projectIn.getGatheredBudget(), 500);
				Project selectProject = projectIn;
				printProject(selectProject);
				printProjectInfo(selectProject);
			}
		
		}
	}

	public void write(String string) {
		System.out.println(string);

	}
}