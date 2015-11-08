package com.sergiisavin.kickstarter.UserInterface;

import java.util.Scanner;

public class DetailedProjectDescriptionPage extends Page {
	
	public DetailedProjectDescriptionPage(Printer printer, RequestData request) {
		this.printer = printer;
		this.requestData = request;
		previousPage = PageType.PROJECTS_PAGE;
	}

	public DetailedProjectDescriptionPage(){
		previousPage = PageType.PROJECTS_PAGE;
	}
	
	public DetailedProjectDescriptionPage(Printer printer) {
		this.printer = printer;
		previousPage = PageType.PROJECTS_PAGE;
	}
	
	@Override
	public void constructPage(){
		header = "/////////////////////////////////\n"+
				 "//DETAILED PROJECT DESCRIPTION//\n"+
				 "////////////////////////////////\n";
		dataArea = constructDataArea();
		footer = "\n----------------------------------\n"
				+ "Enter (exit) - to exit : (prev) - to go to previous page\n";
		whereAmI = "Welcome User Page > Categories > Projects";
	}
	
	private String constructDataArea() {
		String result = "HERE WILL BE DETAILED DESCRIPTION";
		
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
				nextPage = PageType.PROJECTS_PAGE;
				requestData.data = requestData.category;
				flag = false;
				break;
		
			default:
				
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
