package com.sergiisavin.kickstarter.userinterface.pages;

import java.util.Scanner;

import com.sergiisavin.kickstarter.userinterface.printer.Printer;
import com.sergiisavin.kickstarter.userinterface.requestdata.RequestData;

public class CategoriesPage extends Page{

	int numberOfCategories = 0;
	String[] categories;
	
	public CategoriesPage(Printer printer) {
		this.printer = printer;
		previousPage = PageType.WELCOME_USER_PAGE;
	}

	@Override
	public void constructPage(){
		header = "/////////////////////////////////\n"+
				 "//          CATEGORIES         //\n"+
				 "////////////////////////////////\n";
		dataArea = constructDataArea();
		footer = "\n----------------------------------\n"
				+ "Enter (exit) - to exit : (prev) - to go to previous page\n";
		whereAmI = "Welcome User Page > Categories > ";
	}
	
	private String constructDataArea() {
		numberOfCategories = kickstarter.getCategories().length;
		StringBuffer result = new StringBuffer();
		categories = kickstarter.getCategories();
		for(int i = 0; i < categories.length; i++){
			result.append("(" + i + ") ");
			result.append(categories[i]);
			result.append("\n");
		}
		
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
				nextPage = PageType.WELCOME_USER_PAGE;
				flag = false;
				break;
		
			default:
				if(isNumber(input)){
					int choice = toNumber(input);
					if((choice >= 0) && choice < numberOfCategories){
						requestData = new RequestData(categories[choice]);
						nextPage = PageType.PROJECTS_PAGE;
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
