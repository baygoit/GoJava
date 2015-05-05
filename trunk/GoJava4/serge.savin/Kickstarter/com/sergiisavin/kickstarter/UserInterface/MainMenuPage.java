package com.sergiisavin.kickstarter.UserInterface;

import java.util.Scanner;

public class MainMenuPage extends Page{

	public MainMenuPage(){
		
	}
	
	@Override
	public void constructPage(){
		header = "/////////////////////////////////\n"+
				 "//  WELCOME TO TROLLSTARTER    //\n"+
				 "////////////////////////////////\n";
		dataArea = "\n\n(1) Enter as a user\n"
				   + "(2) Enter as a project owner\n"
				   + "(3) Enter as a moderator\n";
		footer = "\n-------------------------------\n"
				+ "Enter (exit) - to exit :\n";
		whereAmI = "Main Menu > ";
	}
	
	@Override
	protected void getInput(){
		Scanner scanner = new Scanner(System.in);

		do{
			input = scanner.nextLine();
			if(input.equals("exit")){
				System.exit(0);
			}
			switch(input){
			case "1":
				nextPage = PageType.WELCOME_USER_PAGE;
				break;
			case "2":
				nextPage = PageType.WELCOME_PROJECT_OWNER_PAGE;
				break;
			case "3":
				nextPage = PageType.WELCOME_MODERATOR_PAGE;
				default:
			}
			
		}while(!(input.equals("1")) && !(input.equals("2")) && !(input.equals("3")));

	}
	
}
