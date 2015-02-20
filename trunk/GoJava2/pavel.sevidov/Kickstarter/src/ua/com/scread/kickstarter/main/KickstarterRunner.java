package ua.com.scread.kickstarter.main;

import ua.com.scread.kickstarter.controller.Controller;
import ua.com.scread.kickstarter.data.Quote;
import ua.com.scread.kickstarter.io.IO;
import ua.com.scread.kickstarter.model.Model;

public class KickstarterRunner {
	private Controller controller;
    
    public KickstarterRunner(Model model, IO io, Quote quote) {
    	this.controller = new Controller(model, io, quote);
    }
    
    public void run() {
        controller.start();
    }
 
}
