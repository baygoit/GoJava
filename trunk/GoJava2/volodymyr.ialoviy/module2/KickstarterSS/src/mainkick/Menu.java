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
		
		ask();
		
		if (sleep(chosenProject)){switcher();}
		
		condition();
		
		menu = menuProject;
		switcher();
	}
	
	private void selectionBorder() {
//		int[] intSwitch = {menuCategories};
	}

	private void print() {
//		printProjects();
	}
	
	private void ask() {
//		askProject(intSwitch);
		
	}
	
	private void condition() {
//		if (compare(intSwitch, chosenProject)) {menu = menuCategories; switcher();}
		
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
