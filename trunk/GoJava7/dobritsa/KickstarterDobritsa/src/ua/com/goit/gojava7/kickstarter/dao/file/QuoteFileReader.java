package ua.com.goit.gojava7.kickstarter.dao.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.FileReader;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class QuoteFileReader extends FileReader<Quote>{

	public QuoteFileReader(File file) {
		super(file);
	}

	@Override
	public List<Quote> readFromFile(BufferedReader bufferedReader) throws IOException {		
		String text;
		while ((text = bufferedReader.readLine()) != null) {
			String author = bufferedReader.readLine();
			data.add(new Quote(text, author));
		}
		return data;
	}

}
