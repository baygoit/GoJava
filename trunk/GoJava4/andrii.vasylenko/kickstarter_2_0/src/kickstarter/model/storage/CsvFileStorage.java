package kickstarter.model.storage;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import kickstarter.model.engine.Category;
import kickstarter.model.engine.Project;
import kickstarter.model.engine.Quote;

public class CsvFileStorage implements Storage {
	public static final String PATH = "src/kickstarter/resources/csv_repository/";
	public static final String QUOTES = "quotes.csv";
	public static final String CATEGORIES = "categories.csv";
	public static final String PROJECTS = "projects.csv";
	public static final char SEPARATOR = ';';

	@Override
	public void addQuote(Quote quote) {
		addToFile(designForCSV(quote), QUOTES);
	}

	@Override
	public Quote getRandomQuote() {
		List<Quote> quotes = parseQuotes(readFile(QUOTES));
		int index = new Random().nextInt(quotes.size());
		return quotes.get(index);
	}

	@Override
	public void addCategory(Category category) {
		addToFile(designForCSV(category), CATEGORIES);
	}

	@Override
	public List<Category> getCategories() {
		List<Category> categories = parseCategories(readFile(CATEGORIES));
		return categories;
	}

	@Override
	public Category getCategory(int index) {
		List<Category> categories = parseCategories(readFile(CATEGORIES));
		return categories.get(index);
	}

	@Override
	public void addProject(Project project, Category category) {
		addToFile(designForCSV(project, category), PROJECTS);
	}

	@Override
	public List<Project> getProjects(Category category) {
		List<Project> projects = parseProjects(readFile(PROJECTS), category);
		return projects;
	}

	@Override
	public Project getProject(int index, Category category) {
		List<Project> projects = parseProjects(readFile(PROJECTS), category);
		return projects.get(index);
	}

	private List<Quote> parseQuotes(List<String[]> data) {
		List<Quote> result = new ArrayList<>();

		for (String[] fields : data) {
			int id = convert(fields[0]);
			String quote = fields[1];
			result.add(new Quote(id, quote));
		}

		return result;
	}

	private String[] designForCSV(Quote quote) {
		String[] fields = new String[2];

		fields[0] = convert(quote.getId());
		fields[1] = quote.getQuote();

		return fields;
	}

	private List<Category> parseCategories(List<String[]> data) {
		List<Category> result = new ArrayList<>();

		for (String[] fields : data) {
			int id = convert(fields[0]);
			String name = fields[1];
			result.add(new Category(id, name));
		}

		return result;
	}

	private String[] designForCSV(Category category) {
		String[] fields = new String[2];

		fields[0] = convert(category.getId());
		fields[1] = category.getName();

		return fields;
	}

	private List<Project> parseProjects(List<String[]> data, Category category) {
		List<Project> result = new ArrayList<>();

		for (String[] fields : data) {
			int id = convert(fields[0]);
			int idOfCategory = convert(fields[1]);
			if (idOfCategory != category.getId()) {
				continue;
			}
			String name = fields[2];
			String description = fields[3];
			int totalAmount = convert(fields[4]);
			int daysLeft = convert(fields[5]);
			String history = fields[6];
			String link = fields[7];
			String questionsAndAnswers = fields[8];
			int collectAmount = convert(fields[9]);
			result.add(new Project(id, name, description, totalAmount, daysLeft, history, link, questionsAndAnswers,
					collectAmount));
		}

		return result;
	}

	private String[] designForCSV(Project project, Category category) {
		String[] fields = new String[10];

		fields[0] = convert(project.getId());
		fields[1] = convert(category.getId());
		fields[2] = project.getName();
		fields[3] = project.getDescription();
		fields[4] = convert(project.getTotalAmount());
		fields[5] = convert(project.getDaysLeft());
		fields[6] = project.getHistory();
		fields[7] = project.getLink();
		fields[8] = project.getQuestionsAndAnswers();
		fields[9] = convert(project.getCollectAmount());

		return fields;
	}

	private List<String[]> readFile(String fileName) {
		try (CSVReader reader = new CSVReader(new FileReader(PATH + fileName), SEPARATOR)) {
			return reader.readAll();
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	private void addToFile(String[] fields, String fileName) {
		try (CSVWriter writer = new CSVWriter(new FileWriter(PATH + fileName, true), SEPARATOR)) {
			writer.writeNext(fields);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}

	private int convert(String value) {
		return Integer.parseInt(value);
	}

	private String convert(int value) {
		return new Integer(value).toString();
	}
}
