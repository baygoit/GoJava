package ua.com.goit.gojava7.kickstarter;

import java.io.FileNotFoundException;

import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.config.DataSource;
import ua.com.goit.gojava7.kickstarter.dao.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.dao.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.dao.QuestionStorage;
import ua.com.goit.gojava7.kickstarter.dao.QuoteStorage;
import ua.com.goit.gojava7.kickstarter.dao.RewardStorage;

public class KickstarterRunner {

	public static void main(String[] args) throws FileNotFoundException {
		DataSource dataSource = DataSource.MEMORY;
		if (args.length != 0 && args[0] != null) {
			try {
				dataSource = DataSource.getByStartupKey(args[0].toLowerCase());
			} catch (IllegalArgumentException e) {
				System.err.println("Type of data source " + args[0] + " if not supported. Fall back to memory");
			}
		}
		System.out.println("-------Kickstarter runs in " + dataSource + " mode-------\n");

		DaoProvider daoProvider = new DaoProvider(dataSource);
		daoProvider.open();

		QuoteStorage quoteStorage = daoProvider.getQuoteDAO();
		CategoryStorage categoryStorage = daoProvider.getCategoryDAO();
		ProjectStorage projectStorage = daoProvider.getProjectDAO();
		QuestionStorage questionsStorage = daoProvider.getQuestionsDAO();
		RewardStorage rewardStorage = daoProvider.getRewardDAO();

		Kickstarter kickstarter = new Kickstarter(quoteStorage, categoryStorage, projectStorage, questionsStorage,
				rewardStorage);
		kickstarter.run();
		kickstarter.shutdown();
	}
}
