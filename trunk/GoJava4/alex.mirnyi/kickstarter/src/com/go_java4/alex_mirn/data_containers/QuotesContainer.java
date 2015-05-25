package com.go_java4.alex_mirn.data_containers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.go_java4.alex_mirn.data.Quote;

public class QuotesContainer extends EntityContainer<Quote> {
//	private List<Quote> data;

	public QuotesContainer() {
		data = new ArrayList<Quote>();
	}

//	public void add(Quote quote) {
//		data.add(quote);
//	}

//	public Quote get(int index) {
//		return (Quote) data.get(index);
//	}

//	public int size() {
//		return data.size();
//	}

	public Quote getRandom() {
		int randomIndex = getRandomIndex();
		return (Quote)data.get(randomIndex);
	}

	private int getRandomIndex() {
		return new Random().nextInt(size());
	}

}
