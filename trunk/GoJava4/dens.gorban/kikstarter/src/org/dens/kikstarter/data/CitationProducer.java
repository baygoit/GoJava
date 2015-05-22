package org.dens.kikstarter.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CitationProducer {
	
	private List<Сitation> citations = new ArrayList<>();
	
	public CitationProducer() {
		citations.add(new Сitation("A lot of times people look at the negative side of what they feel they can't do. \n I always look on the positive side of what I can do.","Chuck Norris"));
		citations.add(new Сitation("Men are like steel. When they lose their temper, they lose their worth.","Chuck Norris"));
		citations.add(new Сitation("I don't initiate violence, I retaliate.","Chuck Norris"));
		citations.add(new Сitation("Good morals lead to good laws.","Chuck Norris"));
		citations.add(new Сitation("Violence is my last option.","Chuck Norris"));
				
	}
	
	public Сitation next() {
		Random generator = new Random();
		int index = generator.nextInt(citations.size());
		return citations.get(index);			
	}
	

}
