package ua.com.scread.kickstarter;

public class MVC {
	private Model model;
	private Controller controller;
    
    public MVC(ConsoleIO consoleIO) {
    	model = new Model();
    	controller = new Controller(model, consoleIO);
    	
    	controller.start();
    }
 
}
