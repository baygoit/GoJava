package goit5.nikfisher.kickstarter.model;

import java.util.Random;


public class QuoteGenerate {

	private Random random;

	public QuoteGenerate(Random random){
		this.random = random;
	}

	public String quoteGenerate(){

		String[] motivators = new String[]{
				"Get involved in the development of interesting projects!",
				"Get involved in the development of interesting projects!_1",
				"Get involved in the development of interesting projects!_2"
		};

		return motivators[getIndex(motivators)];
	}

	private int getIndex(String[] motivators) {
		return random.nextInt(motivators.length);
	}
}
