package com.go_java4.alex_mirn.data_containers;

import java.util.ArrayList;
import java.util.Random;

import com.go_java4.alex_mirn.data.Quote;

public class QuotesContainer extends EntityContainer<Quote> {
	protected Random random;
	
	public QuotesContainer() {
		data = new ArrayList<Quote>();
	}
	
	public QuotesContainer(Random random) {
		this.random = random;
		data = new ArrayList<Quote>();
	}

	public Quote getRandom() {
		int randomIndex = random.nextInt(size());
		return (Quote)data.get(randomIndex);
	}

}
