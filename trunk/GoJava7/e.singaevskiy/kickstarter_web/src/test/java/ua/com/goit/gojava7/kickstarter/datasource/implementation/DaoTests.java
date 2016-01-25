package ua.com.goit.gojava7.kickstarter.datasource.implementation;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	QuotePostgreDAOTest.class, 
	CategoryPostgreDAOTest.class, 
	ProjectPostgreDAOTest.class, 
	QuestionsPostgreDAOTest.class,
	RewardPostgreDAOTest.class,
	PaymentPostgreDAOTest.class
	})
public class DaoTests {

}
