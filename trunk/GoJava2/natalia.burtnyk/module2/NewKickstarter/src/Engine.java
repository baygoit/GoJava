public class Engine {

	private ConsoleView consoleView;
	private InPut inPut;
	
	public Engine() {
		consoleView = new ConsoleView();
		inPut = new InPut();
	}

	public void run() {
		consoleView.displayWelcome();
		consoleView.displayListCategories();
		
		while(true) {
			System.out.print("\n" + "Please select category: ");
			int input = inPut.readInput();
			if(input > 0 && input <= 3) {
				consoleView.displaySelectedCategory(input);
				consoleView.displayProjectsOfCategory();				
				while(true) {
					System.out.print("[1 - ... select project; 0 - back to categories]: ");
					input = inPut.readInput();
					if (input > 0) {
						consoleView.displayCurrentProject(input);
						while(true) {
							System.out.print("[0 - back to projects]: ");	
							input = inPut.readInput();
							if (input == 0) {
								consoleView.displayProjectsOfCategory();
								break;
							}
						}
					} else if(input == 0) {
						consoleView.displayListCategories();
						break;
					}
				}
			} else if (input == 0) {
				System.out.println("Uncorrect number.");
				break;
			}
		}	
	}
}