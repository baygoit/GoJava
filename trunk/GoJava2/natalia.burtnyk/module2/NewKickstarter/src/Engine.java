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
	
		System.out.print("\n" + "Please select category: ");
		consoleView.displaySelectedCategory(inPut.readInput());
		consoleView.displayProjectsOfCategory();
		
		System.out.println("Please select project: ");
		consoleView.displayCurrentProject(inPut.readInput());
	}
}