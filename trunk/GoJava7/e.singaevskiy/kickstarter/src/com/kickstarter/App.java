package com.kickstarter;
import com.kickstarter.controller.MainPageController;
import com.kickstarter.view.MainPage;

public class App {

	public static void main(String[] args) {
		start();
	}
	
	public static void start(){
		
		MainPage page = new MainPage(System.out);
		MainPageController controller = new MainPageController(page, System.in);
		controller.showMainPage();
		
	}	

}
