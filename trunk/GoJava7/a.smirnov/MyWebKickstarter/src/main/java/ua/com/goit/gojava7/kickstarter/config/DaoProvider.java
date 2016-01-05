package ua.com.goit.gojava7.kickstarter.config;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.FaqDao;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.dao.impl.CategoryDaoImpl;
import ua.com.goit.gojava7.kickstarter.dao.impl.FaqDaoImpl;
import ua.com.goit.gojava7.kickstarter.dao.impl.PaymentDaoImpl;
import ua.com.goit.gojava7.kickstarter.dao.impl.ProjectDaoImpl;
import ua.com.goit.gojava7.kickstarter.dao.impl.QuoteDaoImpl;
import ua.com.goit.gojava7.kickstarter.dao.impl.RewardDaoImpl;

public class DaoProvider {
	private InternalDataSource dataSource;

	public DaoProvider(InternalDataSource dataSource) {
		this.dataSource = dataSource;
	}

	public QuoteDao getQuoteDao() {
		QuoteDao quoteDao;
		if (dataSource == InternalDataSource.MYSQL) {
			QuoteDaoImpl quoteDaoMySqlImpl = new QuoteDaoImpl();
			quoteDao = quoteDaoMySqlImpl;
		} else {
			throw new IllegalArgumentException("Unknown data source " + dataSource);
		}
		return quoteDao;
	}

	public CategoryDao getCategoryDao() {
		CategoryDao categoryDao;
		if (dataSource == InternalDataSource.MYSQL) {
			CategoryDaoImpl categoryDaoMysqlImpl = new CategoryDaoImpl();
			categoryDao = categoryDaoMysqlImpl;
		} else {
			throw new IllegalArgumentException("Unknown data source " + dataSource);
		}
		return categoryDao;
	}

	public FaqDao getFaqDao() {
		FaqDao faqDao;
		if (dataSource == InternalDataSource.MYSQL) {
			FaqDaoImpl faqDaoMysqlImpl = new FaqDaoImpl();
			faqDao = faqDaoMysqlImpl;
		} else {
			throw new IllegalArgumentException("Unknown data source " + dataSource);
		}
		return faqDao;
	}

	public PaymentDao getPaymentDao() {
		PaymentDao paymentDao;
		if (dataSource == InternalDataSource.MYSQL) {
			PaymentDaoImpl paymentDaoMysqlImpl = new PaymentDaoImpl();
			paymentDao = paymentDaoMysqlImpl;
		} else {
			throw new IllegalArgumentException("Unknown data source " + dataSource);
		}
		return paymentDao;
	}

	public ProjectDao getProjectDao() {
		ProjectDao projectDao;
		if (dataSource == InternalDataSource.MYSQL) {
			ProjectDaoImpl projectDaoMysqlImpl = new ProjectDaoImpl();
			projectDao = projectDaoMysqlImpl;
		} else {
			throw new IllegalArgumentException("Unknown data source " + dataSource);
		}
		return projectDao;
	}

	public RewardDao getRewardDao() {
		RewardDao rewardDao;
		if (dataSource == InternalDataSource.MYSQL) {
			RewardDaoImpl rewardDaoMysqlImpl = new RewardDaoImpl();
			rewardDao = rewardDaoMysqlImpl;
		} else {
			throw new IllegalArgumentException("Unknown data source " + dataSource);
		}
		return rewardDao;
	}
}
