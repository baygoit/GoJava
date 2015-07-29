package goit.nz.kickstartermvc.storage;

import goit.nz.kickstartermvc.dao.Category;
import goit.nz.kickstartermvc.dao.FAQ;
import goit.nz.kickstartermvc.dao.Project;
import goit.nz.kickstartermvc.dao.Quote;
import goit.nz.kickstartermvc.dao.RewardOption;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileStorage implements DataStorage {
	private static final String CATEGORIES_FILE = "categories.txt";
	private static final String PROJECTS_FILE = "projects.txt";
	private static final String QUOTES_FILE = "quotes.txt";
	private static final String FAQ_FILE = "faqs.txt";
	private static final String REWARD_OPTIONS_FILE = "reward_options.txt";
	private Charset defaultCharset;
	private Path categoriesPath;
	private Path projectsPath;
	private Path quotesPath;
	private Path faqPath;
	private Path rewardOptionsPath;
	private String separator;
	private String mainDir;

	@Override
	public List<Quote> getQuotes() {
		List<String> linesFromFile = null;
		try {
			linesFromFile = Files.readAllLines(quotesPath, defaultCharset);
		} catch (IOException e) {
			throw new RuntimeException("Can't read from quotes.txt", e);
		}
		return parseQuotesFile(linesFromFile);
	}

	private List<Quote> parseQuotesFile(List<String> linesFromFile) {
		List<Quote> quotes = new ArrayList<>();
		if (linesFromFile.size() > 0) {
			for (String line : linesFromFile) {
				String[] parts = line.split(separator);
				quotes.add(new Quote(parts[0], parts[1].trim()));
			}
		}
		return quotes;
	}

	@Override
	public List<Category> getCategories() {
		List<String> linesFromFile = null;
		try {
			linesFromFile = Files.readAllLines(categoriesPath, defaultCharset);
		} catch (IOException e) {
			throw new RuntimeException("Can't read from categories.txt", e);
		}
		return parseCategoriesFile(linesFromFile);
	}

	private List<Category> parseCategoriesFile(List<String> linesFromFile) {
		List<Category> categories = new ArrayList<>();
		if (linesFromFile.size() > 0) {
			for (String line : linesFromFile) {
				String[] parts = line.split(separator);
				Category category = new Category(parts[1]);
				category.setId(Integer.parseInt(parts[0]));
				categories.add(category);
			}
		}
		return categories;
	}

	@Override
	public List<Project> getProjects(String chosenCategoryName) {
		Category chosenCategory = findCategoryByName(chosenCategoryName);
		List<Project> projects = new ArrayList<>();
		if (chosenCategory.getId() > 0) {
			List<String> linesFromFile = null;
			try {
				linesFromFile = Files
						.readAllLines(projectsPath, defaultCharset);
			} catch (IOException e) {
				throw new RuntimeException("Can't read from projects.txt", e);
			}
			projects = parseProjectsFile(chosenCategory, linesFromFile);
		}
		return projects;
	}

	private List<Project> parseProjectsFile(Category chosenCategory,
			List<String> linesFromFile) {
		List<Project> projects = new ArrayList<>();
		if (linesFromFile.size() > 0) {
			for (String line : linesFromFile) {
				String[] parts = line.split(separator);
				if (chosenCategory.getId() == Integer.parseInt(parts[0])) {
					projects.add(createInMemoryProject(chosenCategory, parts));
				}
			}
		}
		return projects;
	}

	private Project createInMemoryProject(Category chosenCategory,
			String[] parts) {
		int id = Integer.parseInt(parts[1]);
		String name = parts[2];
		String desc = parts[3];
		int goal = Integer.parseInt(parts[4]);
		int pledged = Integer.parseInt(parts[5]);
		int daysLeft = Integer.parseInt(parts[6]);
		Project project = new Project(name, desc, goal, pledged, daysLeft);
		project.setCategory(chosenCategory);
		project.setId(id);
		project.addEvents(parts[7].trim());
		project.setLink(parts[8].trim());
		addFAQ(project);
		addRewardOptions(project);
		return project;
	}

	private void addFAQ(Project project) {
		List<String> linesFromFile = null;
		try {
			linesFromFile = Files.readAllLines(faqPath, defaultCharset);
		} catch (IOException e) {
			throw new RuntimeException("Can't read from faqs.txt", e);
		}
		if (linesFromFile.size() > 0) {
			for (String line : linesFromFile) {
				String[] parts = line.split(separator);
				if (project.getId() == Integer.parseInt(parts[0])) {
					String question = parts[1];
					String answer = parts[2].trim();
					project.addFAQ(new FAQ(question, answer));
				}
			}
		}
	}

	private void addRewardOptions(Project project) {
		List<String> linesFromFile = null;
		try {
			linesFromFile = Files.readAllLines(rewardOptionsPath,
					defaultCharset);
		} catch (IOException e) {
			throw new RuntimeException("Can't read from reward_options.txt", e);
		}
		if (linesFromFile.size() > 0) {
			for (String line : linesFromFile) {
				String[] parts = line.split(separator);
				if (project.getId() == Integer.parseInt(parts[0])) {
					int amount = Integer.parseInt(parts[1]);
					String description = parts[2];
					project.addRewardOption(new RewardOption(amount,
							description));
				}
			}
		}
	}

	private Category findCategoryByName(String chosenCategoryName) {
		List<String> linesFromFile = null;
		Category found = null;
		try {
			linesFromFile = Files.readAllLines(categoriesPath, defaultCharset);
		} catch (IOException e) {
			throw new RuntimeException("Can't read from categories.txt", e);
		}
		if (linesFromFile.size() > 0) {
			for (String line : linesFromFile) {
				String[] parts = line.split(separator);
				if (chosenCategoryName.equals(parts[1])) {
					found = new Category(parts[1]);
					found.setId(Integer.parseInt(parts[0]));
					break;
				}
			}
		} else {
			found = new Category("Not found");
		}
		return found;
	}

	@Override
	public void addPledgedAmount(String categoryName, int projectIndex,
			int amount) {
		Project project = getProjects(categoryName).get(projectIndex - 1);
		project.addPledgedAmount(amount);
		rewriteProjectsFile(project);
	}

	private void rewriteProjectsFile(Project project) {
		List<String[]> fileData = new ArrayList<>();
		List<String> linesFromFile = null;
		try {
			linesFromFile = Files.readAllLines(projectsPath, defaultCharset);
		} catch (IOException e) {
			throw new RuntimeException("Can't read from projects.txt", e);
		}
		for (String line : linesFromFile) {
			fileData.add(line.split(separator));
		}
		StringBuilder toFile = new StringBuilder();
		for (String[] parts : fileData) {
			if (project.getId() == Integer.parseInt(parts[1])) {
				parts[5] = String.valueOf(project.getPledgedAmount());
			}
			for (String part : parts) {
				toFile.append(part);
				toFile.append(separator);
			}
			toFile.append(System.lineSeparator());
		}
		try {
			Files.write(projectsPath, toFile.toString().getBytes(),
					StandardOpenOption.CREATE);
		} catch (IOException e) {
			throw new RuntimeException("Can't write to projects.txt", e);
		}
	}

	@Override
	public void addQuestion(String categoryName, int projectIndex,
			String question) {
		int projectId = getProjects(categoryName).get(projectIndex - 1).getId();
		FAQ newFaq = new FAQ(question);
		StringBuilder toFile = new StringBuilder();
		toFile.append(String.valueOf(projectId));
		toFile.append(separator);
		toFile.append(newFaq.getQuestion());
		toFile.append(separator + " " + separator);
		toFile.append(System.lineSeparator());
		try {
			Files.write(faqPath, toFile.toString().getBytes(),
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException("Can't write to faqs.txt", e);
		}
	}

	@Override
	public void initStorage() {

		// TODO move this to property file
		separator = "<separator>";
		mainDir = "resources";

		defaultCharset = Charset.defaultCharset();
		categoriesPath = FileSystems.getDefault().getPath(mainDir,
				CATEGORIES_FILE);
		projectsPath = FileSystems.getDefault().getPath(mainDir, PROJECTS_FILE);
		quotesPath = FileSystems.getDefault().getPath(mainDir, QUOTES_FILE);
		faqPath = FileSystems.getDefault().getPath(mainDir, FAQ_FILE);
		rewardOptionsPath = FileSystems.getDefault().getPath(mainDir,
				REWARD_OPTIONS_FILE);
	}

}
