package ua.kutsenko.KickstarterGoIt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Category {

	private String name;
	private List<Category> categoriesList = new ArrayList<Category>();
	private List<Project> projectList = new ArrayList<Project>();
	private Project project = new Project();
	private int selector;
	private Category category;
	



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
			System.out.println(i + 1 + "-" + categoriesList.get(i).name);
		}
	}

	public void initCategory() {
		categoriesList.add(new Category("It", project.getItProjectList()));
		categoriesList.add(new Category("Films", project.getFilmsProjectList()));
		categoriesList.add(new Category("Music", project.getMusicProjectList()));
	}

	private void printString(String toPrint) {
		System.out.print(toPrint);
	}

	public void showProjects(Category selectedCategory) {
		for (int i = 0; i < selectedCategory.projectList.size(); i++) {
			Project project = selectedCategory.projectList.get(i);
			System.out.print(i + 1 + " - ");
			printProject(project);
		}

	}

	private void printProject(Project project) {
		System.out.println("Name project - " + project.getName());
		System.out.println("Description project - " + project.getDecription());
		System.out.println("Required budget - " + project.getRequiredBudget() + "$");
		System.out.println("Gathered budget - " + project.getGatheredBudget() + "$");
		System.out.println("days to go project - " + project.getDaysLeft());
		System.out.println("--------------------");

	}

	public void printProjectInfo(Project project) {
		System.out.println("History project - " + project.getHistoryProject());
		System.out.println("url to video - " + project.getUrlToVideo());
		System.out.println("Question and answer - " + project.getqA());

	}

	public void selectProject(Category selectedCategory) {
		System.out.println("Select project, 0 to exit ");
		Scanner sc = new Scanner(System.in);
		selector = sc.nextInt();
		if(selector == 0){
			endApp(selector);
		}
		Project selectProject = selectedCategory.projectList.get(selector - 1);
		printProject(selectProject);
		printProjectInfo(selectProject);
		//return selectProject;
	}

	
	public Category selectCategory() {
		printString("Select category, 0 to exit :");
		Scanner sc = new Scanner(System.in);
		selector = sc.nextInt() - 1;
		if(selector == -1){
			endApp(selector);
		}
		System.out.println("You selelect: " + categoriesList.get(selector).getName());
		category = categoriesList.get(selector);
		return category;

	}

	private void endApp(int selector2) {
		System.exit(selector2);
		
	}

}
