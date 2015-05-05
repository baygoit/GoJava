package com.sergiisavin.kickstarter.UserInterface;

import java.util.Scanner;

public class CategoriesPage extends Page{

	public CategoriesPage(){
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
		StringBuffer result = new StringBuffer();
		String[] categories = kickstarter.getCategories();
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
		
		do{
			input = scanner.nextLine();
			if(input.equals("exit")){
				nextPage = PageType.MAIN_MENU_PAGE;
				break;
			}
			switch(input){
			case "prev":
				nextPage = PageType.WELCOME_USER_PAGE;
				break;
		
				default:
			}
			
		}while(!(input.equals("1")) && !(input.equals("prev")));
	}
}
