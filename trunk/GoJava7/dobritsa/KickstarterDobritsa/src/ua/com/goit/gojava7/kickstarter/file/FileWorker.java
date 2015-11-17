package ua.com.goit.gojava7.kickstarter.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class FileWorker {

	public static Category readCategory(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		exists(fileName);
		Category category;
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			try {
				category = new Category(in.readLine());
				
				while ((in.readLine()) != null) {
					Project project = new Project();
					project.setName(in.readLine());
					project.setDescription(in.readLine());
					//Integer g = new Integer(in.readLine());
					project.setGoal(new Integer(in.readLine()));
					project.setPledged(new Integer(in.readLine()));
					project.setDaysToGo(new Integer(in.readLine()));
					project.setHistory(in.readLine());
					project.setLink(in.readLine());
					//TODO addQuestion				
					category.add(project);
				}
			} finally {
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return category;
	}
	
	public static List<Quote> readQuotes(String fileName) throws FileNotFoundException {
		List<Quote> list = new ArrayList<Quote>();
		File file = new File(fileName);
		exists(fileName);
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
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
