package com.sergiisavin.kickstarter.UserInterface;

import java.util.Scanner;

public class WelcomeProjectOwnerPage extends Page{

	public WelcomeProjectOwnerPage(){
		
	}
	
	@Override
	public void constructPage(){
		header = "\n\n/////////////////////////////////\n"+
				 "//  WELCOME PROJECT OWNER      //\n"+
				 "////////////////////////////////\n";
		dataArea = "\n\n(1) Create project\n"
				   + "(2) Show my projects";
		
		footer = "\n---------------------------\n"
				+ "Enter (exit) - to exit :\n";
		whereAmI = "Welcome Project Owner Page > ";
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
			case "1":
				
				break;
		
				default:
			}
			
		}while(!(input.equals("1")));
	}
}
