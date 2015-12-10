package ua.com.goit.gojava7.kickstarter;

import java.io.FileNotFoundException;

import ua.com.goit.gojava7.kickstarter.config.DataSource;
import ua.com.goit.gojava7.kickstarter.dao.DaoFactory;
import ua.com.goit.gojava7.kickstarter.dao.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.dao.storage.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.dao.storage.QuestionStorage;
import ua.com.goit.gojava7.kickstarter.dao.storage.QuoteStorage;

public class KickstarterRunner{

	public static void main(String[] args) throws FileNotFoundException {
		DataSource dataSource = DataSource.getDataSource();
		if (args.length != 0 && args[0] != null) {
			try {
				dataSource = DataSource.getByStartupKey(args[0].toLowerCase());
			} catch (IllegalArgumentException e) {
				System.err.println("Type of data source " + args[0] + " if not supported. Fall back to memory");
				e.printStackTrace();
			}
		}
		System.out.println("-------Kickstarter runs in " + dataSource + " mode-------\n");

		DaoFactory daoFactory = new DaoFactory(dataSource);

		QuoteStorage quoteStorage = daoFactory.getQuoteStorage();
		CategoryStorage categoryStorage = daoFactory.getCategoryStorage();
		ProjectStorage projectStorage = daoFactory.getProjectStorage();
		QuestionStorage questionsStorage = daoFactory.getQuestionsStorage();
		Body body = new Body();

		Kickstarter kickstarter = new Kickstarter(quoteStorage, categoryStorage, body, projectStorage, questionsStorage);
		kickstarter.run();
		kickstarter.shutdown();
		daoFactory.close();

	}

}
