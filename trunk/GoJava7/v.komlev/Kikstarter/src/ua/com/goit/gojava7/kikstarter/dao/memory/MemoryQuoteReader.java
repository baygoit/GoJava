package ua.com.goit.gojava7.kikstarter.dao.memory;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kikstarter.domain.Quote;

public class MemoryQuoteReader {

	public List<Quote> readQuotes() {
		List<Quote> quotes=new ArrayList<>();
		
		quotes.add(new Quote("Two things are infinite: the universe and human stupidity and I'm not sure about the universe.", "Albert Einstein"));
		quotes.add(new Quote("Coming together is a beginning; keeping together is progress; working together is success.", "Henry Ford"));
		quotes.add(new Quote("Mistakes are always forgivable, if one has the courage to admit them.", "Bruce Lee"));
		quotes.add(new Quote("Give me six hours to chop down a tree and I will spend the first four sharpening the axe.", "Abraham Lincoln"));
		
		return quotes;
	}

}
