package ua.com.goit.gojava7.kickstarter;

import java.io.File;
import java.util.List;
import java.util.Random;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.dao.CategoryReader;
import ua.com.goit.gojava7.kickstarter.dao.ProjectReader;
import ua.com.goit.gojava7.kickstarter.dao.QuoteReader;
import ua.com.goit.gojava7.kickstarter.dao.RewardReader;
import ua.com.goit.gojava7.kickstarter.dao.file.FileCategoryReader;
import ua.com.goit.gojava7.kickstarter.dao.file.FileProjectReader;
import ua.com.goit.gojava7.kickstarter.dao.file.FileQuoteReader;
import ua.com.goit.gojava7.kickstarter.dao.file.FileRewardReader;
import ua.com.goit.gojava7.kickstarter.dao.memory.MemoryCategoryReader;
import ua.com.goit.gojava7.kickstarter.dao.memory.MemoryProjectReader;
import ua.com.goit.gojava7.kickstarter.dao.memory.MemoryQuoteReader;
import ua.com.goit.gojava7.kickstarter.dao.memory.MemoryRewardReader;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.domain.Reward;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class KickstarterRunner {	
	private static final File QUOTES_FILE = new File("./quotes.csv");
	private static final File CATEGORIES_FILE = new File("./categories.csv");
	private static final File PROJECTS_FILE = new File("./projects.csv");
	private static final File REWARDS_FILE = new File("./rewards.csv");
	
	private static QuoteReader getQuoteReader(boolean isFromFile) {
		if (!isFromFile) {
			return new MemoryQuoteReader();
		} else {
			return new FileQuoteReader(QUOTES_FILE);
		}
	}
	
	private static CategoryReader getCategoryReader(boolean isFromFile) {
		if (!isFromFile) {
			return new MemoryCategoryReader();
		} else {
			return new FileCategoryReader(CATEGORIES_FILE);
		}
	}
	
	private static ProjectReader getProjectReader(boolean isFromFile) {
		if (!isFromFile) {
			return new MemoryProjectReader();
		} else {
			return new FileProjectReader(PROJECTS_FILE);
		}
	}
	
	private static RewardReader getRewardsReader(boolean isFromFile) {
		if (!isFromFile) {
			return new MemoryRewardReader();
		} else {
			return new FileRewardReader(REWARDS_FILE);
		}
	}
	
	public static void main(String[] args) {	
		boolean isFromFile = false;
		if (args.length != 0) {
			isFromFile = true;
		}
		
		ConsolePrinter consolePrinter = new ConsolePrinter();
		ConsoleScanner consoleReader = new ConsoleScanner();
		QuoteStorage quoteStorage = initQuotes(isFromFile);
		CategoryStorage categoryStorage = initCategories(isFromFile);
		ProjectStorage projectStorage = initProjects(isFromFile, categoryStorage);
		initRewards(isFromFile, projectStorage);
		
		Kickstarter kickstarter = new Kickstarter(consolePrinter, consoleReader, quoteStorage, categoryStorage);
		kickstarter.runKickstarter();
		kickstarter.shutdown();

	}

	private static QuoteStorage initQuotes(boolean isFromFile) {
		QuoteStorage quoteStorage = new QuoteStorage(new Random());
		QuoteReader quoteReader = getQuoteReader(isFromFile);
		List<Quote> quotes = quoteReader.readQuotes();
		quoteStorage.setQuotes(quotes);
		return quoteStorage;
	}

	private static CategoryStorage initCategories(boolean isFromFile) {
		CategoryStorage categoryStorage = new CategoryStorage();
		
		CategoryReader categoryReader = getCategoryReader(isFromFile);
		List<Category> categorys = categoryReader.readCategories();
		categoryStorage.setCategories(categorys);
		return categoryStorage;
	}


	private static ProjectStorage initProjects(boolean isFromFile, CategoryStorage categoryStorage) {
		ProjectStorage projectStorage = new ProjectStorage();
		
		ProjectReader projectReader = getProjectReader(isFromFile);
		List<Project> projects = projectReader.readProjects();
		
		Category category;
		for (Project project : projects) {
			category = categoryStorage.getCategory(project.getCategoryId());
			category.addProject(project);
		}
		
		projectStorage.setProjects(projects);
		return projectStorage;
	}
	
	private static void initRewards(boolean isFromFile, ProjectStorage projectStorage) {	
		RewardReader rewardReader = getRewardsReader(isFromFile);
		List<Reward> rewards = rewardReader.readRewards();
		
		Project project;
		for (Reward reward : rewards) {
			project = projectStorage.getProject(reward.getProjectId());
			project.addReward(reward);
		}

	}
}
