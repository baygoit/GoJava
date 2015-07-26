package goit5.nikfisher.kickstarter;

import goit5.nikfisher.kickstarter.model.*;
import goit5.nikfisher.kickstarter.streams.ConsoleIO;

import java.util.Random;

public class Bootstrap {

	public static void main(String[] args){
		Main app = new Main(new ConsoleIO(), new QuoteGenerate(new Random()));
		app.run();
	}
}
