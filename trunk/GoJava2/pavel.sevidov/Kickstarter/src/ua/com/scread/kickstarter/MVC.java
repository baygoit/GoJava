package ua.com.scread.kickstarter;

public class MVC {
	private Model model;
	private View view;
	private Scan scan;
	private Controller controller;
    
    public MVC() {
    	model = new Model();
    	view = new View();
    	scan = new Scan();
    	controller = new Controller(model, view, scan);
    	
    	controller.start();
    }
 
}
