package goit5.nikfisher.kickstarter;

import goit5.nikfisher.kickstarter.model.*;
import goit5.nikfisher.kickstarter.streams.InputOutputConsole;

import java.util.Random;

public class Runner {

	public static void main(String[] args){


		Main app = new Main(new InputOutputConsole(), new QuoteGenerate(new Random()));
		app.run();
	}

}
