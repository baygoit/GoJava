package ua.com.scread.kickstarter;

public class KickstarterRunner {
	private Model model;
	private Controller controller;
	private IO io;
    
    public KickstarterRunner(Model model, IO io, QuoteGenerator quote) {
    	this.model = model;
    	this.io = io;
    	this.controller = new Controller(model, io, quote);
    }
    
    public void run() {
        controller.start();
    }
 
}
