package ua.kutsenko.KickstarterGoIt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Category {

	private String name;
	private List<Category> categoriesList = new ArrayList<Category>();
	private List<Project> projectList = new ArrayList<Project>();
	private Project project;
	private int selector ;
	private Category category;

	public Category(String name, List<Project> projectList ) {
		this.name = name;
		this.projectList = projectList;		
	}

	public Category() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Category> getCategoriesList() {

		return categoriesList;
	}

	public void showCategory() {
		
		initCategory();
		for (int i = 0; i < categoriesList.size(); i++) {
			System.out.println(i+1 +" "+categoriesList.get(i).name);
		}
	}

	public void initCategory() {
		categoriesList.add(new Category("It" , project.getItProjectList()));
		categoriesList.add(new Category("Films" , project.getFilmsProjectList()));
		categoriesList.add(new Category("Music" , project.getMusicProjectList()));
	}

	public void selectCategory() {
		//initCategory();
		printString("Select category:");
		Scanner sc = new Scanner(System.in);
		selector = sc.nextInt() - 1;
		
		System.out.println("You selelect: " +categoriesList.get(selector).getName());
		
	}
	
	private void printString(String toPrint){
		System.out.print(toPrint);
	}

	public void showProject() {
		categoriesList.get(selector).project.showInfo();
		
	}
	public void test(){
		System.out.println(project.getItProjectList().toString());
	}
//	private String projectInfo(){
		
	//}
	
	
	

}
