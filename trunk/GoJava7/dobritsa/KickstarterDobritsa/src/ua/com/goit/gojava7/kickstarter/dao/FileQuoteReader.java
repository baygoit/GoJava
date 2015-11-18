package ua.com.goit.gojava7.kickstarter.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class FileQuoteReader extends FileReader<Quote> implements QuoteReader {

	public FileQuoteReader(File file) {
		super(file);
	}

	@Override
	public List<Quote> readIt() throws IOException {
		String line;
		while ((line = fileReader.readLine()) != null) {
			Quote quote = new Quote();
			quote.setText(line);
			quote.setAuthor(fileReader.readLine());
			data.add(quote);
		}
		return data;
	}
}
