package com.sergiisavin.kickstarter.UserInterface;

import java.util.Scanner;

public class WelcomeUserPage extends Page {

	public WelcomeUserPage(){
		
	}
	
	@Override
	public void constructPage(){
		header = "\n\n" + kickstarter.getRandomQuote();
		dataArea = "\n\n(1) Categories\n";
		footer = "\nEnter (exit) - to exit :\n";
		whereAmI = "Welcome User Page > ";
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
				nextPage = PageType.CATEGORIES_PAGE;
				break;
		
				default:
			}
			
		}while(!(input.equals("1")));
	}
}
