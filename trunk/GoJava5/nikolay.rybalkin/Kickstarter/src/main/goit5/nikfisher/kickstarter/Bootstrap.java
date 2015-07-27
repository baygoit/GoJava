package goit5.nikfisher.kickstarter;


import goit5.nikfisher.kickstarter.model.QuoteGenerate;
import goit5.nikfisher.kickstarter.streams.ConsoleIO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;


public class Bootstrap {

	private static final Logger LOGGER = LogManager.getLogger(Bootstrap.class);

	public static void main(String[] args){
		LOGGER.info("Start program.");
		Main app = new Main(new ConsoleIO(), new QuoteGenerate(new Random()));
		app.run();
		LOGGER.info("Finished program.");
	}
}
