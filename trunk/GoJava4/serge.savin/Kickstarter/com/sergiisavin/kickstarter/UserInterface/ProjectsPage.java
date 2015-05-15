package com.sergiisavin.kickstarter.UserInterface;

import java.util.Scanner;

public class ProjectsPage extends Page {

	private String[] projects;
	private int numberOfProjects;
	private String category;
	
	public ProjectsPage(Printer printer, RequestData request) {
		requestData = request;
		this.printer = printer;
		this.requestData = request;
		this.category = request.data;
	}

	public ProjectsPage(){
		previousPage = PageType.CATEGORIES_PAGE;
	}
	
	public ProjectsPage(Printer printer) {
		this.printer = printer;
	}
	
	@Override
	public void constructPage(){
		header = "/////////////////////////////////\n"+
				 "//          PROJECTS           //\n"+
				 "////////////////////////////////\n";
		dataArea = constructDataArea();
		footer = "\n----------------------------------\n"
				+ "Enter (exit) - to exit : (prev) - to go to previous page\n";
		whereAmI = "Welcome User Page > Categories > Projects";
	}
	
	private String constructDataArea() {
		StringBuffer result = new StringBuffer();
		projects = kickstarter.getProjectsByCategory(requestData.data);
		for(int i = 0; i < projects.length; i++){
			result.append("(" + i + ") ");
			result.append(projects[i]);
			result.append("\n");
		}
		numberOfProjects = kickstarter.getProjectsByCategory(requestData.data).length;
		return result.toString();
	}
	
	@Override
	protected void getInput(){
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		do{
			input = scanner.nextLine();
			if(input.equals("exit")){
				nextPage = PageType.MAIN_MENU_PAGE;
				flag = false;
				break;
			}
			switch(input){
			case "prev":
				nextPage = PageType.CATEGORIES_PAGE;
				flag = false;
				break;
		
			default:
				if(isNumber(input)){
					int choice = toNumber(input);
					if((choice >= 0) && choice < numberOfProjects){
						requestData = new RequestData(projects[choice]);
						requestData.category = this.category;
						nextPage = PageType.DETAILED_PROJECT_DESCRIPTION_PAGE;
						flag = false;
					}
				}
			}
			
		}while(flag);
}

	private int toNumber(String input) {
		return Integer.parseInt(input);
	}

	private boolean isNumber(String input) {
		boolean result = false;
		try{
			int number = Integer.parseInt(input);
			result = true;
		}catch(Exception e){
			
		}
		return result;
	}
}
