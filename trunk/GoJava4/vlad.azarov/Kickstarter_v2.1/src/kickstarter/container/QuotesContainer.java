package kickstarter.container;

import java.util.ArrayList;
import java.util.Random;
import kickstarter.model.Quote;


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
