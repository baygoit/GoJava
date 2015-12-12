package ua.com.goit.gojava7.kickstarter;

import java.io.FileNotFoundException;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.DaoFactory;
import ua.com.goit.gojava7.kickstarter.dao.MyDataSource;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;

public class KickstarterRunner {

	public static void main(String[] args) throws FileNotFoundException {
		MyDataSource dataSource = MyDataSource.MEMORY;
		if (args.length != 0 && args[0] != null) {
			try {
				dataSource = MyDataSource.getByStartupKey(args[0].toLowerCase());
			} catch (IllegalArgumentException e) {
				System.err.println("Type of data source " + args[0] + " if not supported. Fall back to memory");
			}
		}
		System.out.println("-------Kickstarter runs in " + dataSource + " mode-------\n");

		DaoFactory daoFactory = new DaoFactory(dataSource);
		
		QuoteDao quoteStorage = daoFactory.getQuoteDAO();
		CategoryDao categoryStorage = daoFactory.getCategoryDAO();
		ProjectDao projectStorage = daoFactory.getProjectDAO();
		QuestionDao questionsStorage = daoFactory.getQuestionDAO();
		RewardDao rewardStorage = daoFactory.getRewardDAO();

		Kickstarter kickstarter = new Kickstarter(quoteStorage, categoryStorage, projectStorage, questionsStorage,
				rewardStorage);
		kickstarter.run();
		kickstarter.shutdown();		
	}
}
