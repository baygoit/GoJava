package ua.com.goit.gojava7.kickstarter.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class FileWorker {

	public static List<Quote> readQuotes(String fileName) throws FileNotFoundException {		
		List<Quote> list = new ArrayList<Quote>();		
		File file = new File(fileName);
		exists(fileName);

		try {			
			BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
			try {
				String line;
				while ((line = in.readLine()) != null) {
					Quote quote = new Quote();
					quote.setText(line);	
					quote.setAuthor(in.readLine());				
					list.add(quote);
				}
			} finally {
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}	
		return list;
	}

	private static void exists(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		if (!file.exists()) {
			throw new FileNotFoundException(file.getName());
		}
	}

}
