package mainkick;

import java.io.IOException;

public class Menu {
	private InputsConsole choice;
	private OutputConsole out;
	
	public Menu(InputsConsole choice, OutputConsole out){
		this.choice = choice;
		this.out = out;
	}
	
	Check check = new Check(new InputsConsole(), new OutputConsole());
	
	private void menu(){
		selectionBorder();
		print();
		
//		ask();
		choice = check.parameter;
		
//		condition();
		if (sleep(choice)){switcher();}
		
		
		print2();
		
//		transition();
		menu = menuProjects;
		switcher();
	}
	
	private void selectionBorder() {
//		int[] intSwitch = {menuCategories};
	}

	private void print() {
//		printer(categories.readAllCatecories());
//		printer("Choice Category Number: ");
		
	}
	
	private void ask() {
//		chosenCategory = check.checkNumber(category.kickContainCategory(categories));
		
	}
	
	private void condition() {
//		if (sleep(chosenCategory)){switcher();};
		
	}
	
	private void print2() {
//		printer("Your chosen category: " + category.showCatecoryName(chosenCategory - 1, categories) + ", containing the following projects: ");
		
	}
	
	private void transition() {
//		menu = menuProjects;
//		switcher();		
	}

	
	private void switcher() throws InterruptedException, IOException{
//		switch(menu){
//			case 222: categories(); break;
//			case 333: projects(); break;
//			case 444: project(); break;
//			case 555: payment(); break;
//			case 666: question(); break;
//		}
	}
	
	private Boolean sleep(int m) throws InterruptedException, IOException{
		Boolean b = false;
		if (m == 777){					//TODO
			Thread.sleep(10000);
			b = true;
		}
		return b;
	}

}
