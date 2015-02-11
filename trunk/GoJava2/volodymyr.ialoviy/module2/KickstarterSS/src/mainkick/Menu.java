package mainkick;

public class Menu {
	private InputsConsole choice;
	private OutputConsole out;
	
	public Menu(InputsConsole choice, OutputConsole out){
		this.choice = choice;
		this.out = out;
	}
	
	
	private void menu(){
		selectionBorder();
		print();
		ask();
		condition();
		print2();
		transition();
	}
	
	private void transition() {
//		menu = menuProjects;
//		switcher();		
	}

	private void print2() {
//		printer("Your chosen category: " + category.showCatecoryName(chosenCategory - 1, categories) + ", containing the following projects: ");
		
	}

	private void condition() {
//		if (sleep(chosenCategory)){switcher();};
		
	}

	private void ask() {
//		chosenCategory = check.checkNumber(category.kickContainCategory(categories));
		
	}

	private void print() {
//		printer(categories.readAllCatecories());
//		printer("Choice Category Number: ");
		
	}

	private void selectionBorder() {
//		int[] intSwitch = {menuCategories};
	}

}
