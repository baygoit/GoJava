package com.go_java4.alex_mirn.data_containers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.go_java4.alex_mirn.data.Quote;

public class QuotesContainer extends EntityContainer<Quote> {

	public QuotesContainer() {
		data = new ArrayList<Quote>();
	}

	public Quote getRandom() {
		int randomIndex = getRandomIndex();
		return (Quote)data.get(randomIndex);
	}

	private int getRandomIndex() {
		return new Random().nextInt(size());
	}

}
