package goit5.nikfisher.kickstarter;

import goit5.nikfisher.kickstarter.model.*;
import goit5.nikfisher.kickstarter.streams.ConsoleIO;

import java.util.Random;
import java.util.logging.Logger;

public class Bootstrap {

	private static final Logger log = Logger.getLogger(String.valueOf(Bootstrap.class));

	public static void main(String[] args){
		Main app = new Main(new ConsoleIO(), new QuoteGenerate(new Random()));
		app.run();
		log.info("This is an informational message!");
	}
}
