package goit.nz.kickstartermvc.storage;

import goit.nz.kickstartermvc.dao.Category;
import goit.nz.kickstartermvc.dao.FAQ;
import goit.nz.kickstartermvc.dao.Project;
import goit.nz.kickstartermvc.dao.ProjectEvent;
import goit.nz.kickstartermvc.dao.Quote;
import goit.nz.kickstartermvc.dao.RewardOption;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FileStorage implements DataStorage {
	private static final Path FILE_PROPS_PATH = FileSystems.getDefault()
			.getPath("props", "file.properties");
	private Charset defaultCharset;
	private Path categoriesPath;
	private Path projectsPath;
	private Path quotesPath;
	private Path faqPath;
	private Path rewardOptionsPath;
	private Path eventsPath;
	private String separator;
	private String mainDir;

	@Override
	public List<Quote> getQuotes() {
		List<String> linesFromFile = null;
		try {
			linesFromFile = Files.readAllLines(quotesPath, defaultCharset);
		} catch (IOException e) {
			throw new RuntimeException(getFileMissedMsg(quotesPath, true), e);
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
			throw new RuntimeException(getFileMissedMsg(categoriesPath, true),
					e);
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
		if (chosenCategory != null) {
			List<String> linesFromFile = null;
			try {
				linesFromFile = Files
						.readAllLines(projectsPath, defaultCharset);
			} catch (IOException e) {
				throw new RuntimeException(
						getFileMissedMsg(projectsPath, true), e);
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
		String deadline = parts[6].trim();
		Project project = new Project(name, desc, goal, pledged, deadline);
		project.setCategory(chosenCategory);
		project.setId(id);
		project.setLink(parts[7].trim());
		addEvents(project);
		addFAQ(project);
		addRewardOptions(project);
		return project;
	}

	private void addFAQ(Project project) {
		List<String> linesFromFile = null;
		try {
			linesFromFile = Files.readAllLines(faqPath, defaultCharset);
		} catch (IOException e) {
			throw new RuntimeException(getFileMissedMsg(faqPath, true), e);
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
	
	private void addEvents(Project project) {
		List<String> linesFromFile = null;
		try {
			linesFromFile = Files.readAllLines(eventsPath, defaultCharset);
		} catch (IOException e) {
			throw new RuntimeException(getFileMissedMsg(eventsPath, true), e);
		}
		if (linesFromFile.size() > 0) {
			for (String line : linesFromFile) {
				String[] parts = line.split(separator);
				if (project.getId() == Integer.parseInt(parts[0])) {
					String desc = parts[1];
					String date = parts[2];
					project.addEvent(new ProjectEvent(desc, date));
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
			throw new RuntimeException(
					getFileMissedMsg(rewardOptionsPath, true), e);
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
		Category found = null;
		List<Category> categories = getCategories();
		for (Category current : categories) {
			if (chosenCategoryName.equals(current.getName())) {
				found = current;
				break;
			}
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
			throw new RuntimeException(getFileMissedMsg(projectsPath, true), e);
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
			throw new RuntimeException(getFileMissedMsg(projectsPath, false), e);
		}
	}

	@Override
	public void addQuestion(String categoryName, int projectIndex,
			String question) {
		long projectId = getProjects(categoryName).get(projectIndex - 1).getId();
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
			throw new RuntimeException(getFileMissedMsg(faqPath, false), e);
		}
	}

	@Override
	public void initStorage() {
		Properties fileProps = new Properties();
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		try (InputStream input = classLoader
				.getResourceAsStream(FILE_PROPS_PATH.toString())) {
			fileProps.load(input);
			separator = fileProps.getProperty("separator");
			mainDir = fileProps.getProperty("main_dir");
			defaultCharset = Charset.defaultCharset();
			categoriesPath = FileSystems.getDefault().getPath(mainDir,
					fileProps.getProperty("categories_file"));
			projectsPath = FileSystems.getDefault().getPath(mainDir,
					fileProps.getProperty("projects_file"));
			quotesPath = FileSystems.getDefault().getPath(mainDir,
					fileProps.getProperty("quotes_file"));
			faqPath = FileSystems.getDefault().getPath(mainDir,
					fileProps.getProperty("faq_file"));
			rewardOptionsPath = FileSystems.getDefault().getPath(mainDir,
					fileProps.getProperty("rewards_file"));
			eventsPath = FileSystems.getDefault().getPath(mainDir,
					fileProps.getProperty("events_file"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getFileMissedMsg(Path path, boolean read) {
		String operation = read ? "read from" : "write to";
		return String.format("Can't %s %s", operation, path.getFileName()
				.toString());
	}

}
