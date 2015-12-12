package ua.com.goit.gojava7.kickstarter;

import java.io.FileNotFoundException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.DaoFactory;
import ua.com.goit.gojava7.kickstarter.dao.MyDataSource;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;

public class KickstarterRunner {

	public static void main(String[] args) throws FileNotFoundException {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("./applicationContext.xml");
		StringDataType obj = (StringDataType) context.getBean("stringDataType");
			
		MyDataSource dataSource = MyDataSource.getByKey(obj.getDataType().toUpperCase());
		
		System.out.println("-----------------------------");
		System.out.println("read from context: " + obj.getDataType());
		System.out.println("get from enum: " + dataSource);
		System.out.println("-----------------------------");		
				
		DaoFactory daoFactory = new DaoFactory(dataSource);
		QuoteDao quoteStorage = daoFactory.getQuoteDAO();
		CategoryDao categoryStorage = daoFactory.getCategoryDAO();
		ProjectDao projectStorage = daoFactory.getProjectDAO();
		QuestionDao questionsStorage = daoFactory.getQuestionDAO();
		RewardDao rewardStorage = daoFactory.getRewardDAO();

		Kickstarter kickstarter = new Kickstarter(quoteStorage, categoryStorage, projectStorage, questionsStorage,
				rewardStorage);
		kickstarter.run();
		context.close();
	}
}
