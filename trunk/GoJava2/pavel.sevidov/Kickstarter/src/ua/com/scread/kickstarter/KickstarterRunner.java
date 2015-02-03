package ua.com.scread.kickstarter;

public class KickstarterRunner {
	private Model model;
	private Controller controller;
	private IO io;
    
    public KickstarterRunner(Model model, IO io) {
    	this.model = model;
    	this.io = io;
    	this.controller = new Controller(model, io);
    	
    	controller.start();
    }
 
}
