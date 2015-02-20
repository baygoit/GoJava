public class Engine {

	private ConsoleView consoleView;
	private InPut inPut;
	private DataStorage storage;
	public Engine() {
		consoleView = new ConsoleView();
		inPut = new InPut();
		storage = new DataStorage();
	}

	public void consolePart_1() {
		System.out.print("\n" + "Please select category: ");
		int input = inPut.readInput();
		if(input > 0 && input <= storage.getCategoriesList().size()) {
			consoleView.displaySelectedCategory(input);
			consoleView.displayProjectsOfCategory();	
			consolePart_2();
		    consolePart_1();
		}else  {
		       System.out.println("Incorrect number. Please try again.");
		       consolePart_1();
		}
	}

	public void consolePart_2() {
		System.out.print("(Press\"0\" - back to categories.)" + "\n" + "Select project: ");
		int input = inPut.readInput();
		if (input > 0) {
			consoleView.displayCurrentProject(input);
			consolePart_3();
			consolePart_2();
		} else if (input == 0) {
			consoleView.displayListCategories();
		}
	}

	public void consolePart_3() {
		System.out.print("\n" + "Press \"0\"  - back to projects: ");
		int input = inPut.readInput();
		if (input == 0) {
			consoleView.displayProjectsOfCategory();
		} else {
			consolePart_3();
		}
	}

	public void run() {
		consoleView.displayWelcome();
		consoleView.displayListCategories();
		consolePart_1();
	}
}