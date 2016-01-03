package ua.com.goit.gojava7.kickstarter.config;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.FaqDao;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.dao.impl.CategoryDaoImpl;
import ua.com.goit.gojava7.kickstarter.dao.impl.FaqDaoMysqlImpl;
import ua.com.goit.gojava7.kickstarter.dao.impl.PaymentDaoMysqlImpl;
import ua.com.goit.gojava7.kickstarter.dao.impl.ProjectDaoImpl;
import ua.com.goit.gojava7.kickstarter.dao.impl.QuoteDaoImpl;
import ua.com.goit.gojava7.kickstarter.dao.impl.RewardDaoMysqlImpl;

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
			FaqDaoMysqlImpl faqDaoMysqlImpl = new FaqDaoMysqlImpl();
			faqDao = faqDaoMysqlImpl;
		} else {
			throw new IllegalArgumentException("Unknown data source " + dataSource);
		}
		return faqDao;
	}

	public PaymentDao getPaymentDao() {
		PaymentDao paymentDao;
		if (dataSource == InternalDataSource.MYSQL) {
			PaymentDaoMysqlImpl paymentDaoMysqlImpl = new PaymentDaoMysqlImpl();
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
			RewardDaoMysqlImpl rewardDaoMysqlImpl = new RewardDaoMysqlImpl();
			rewardDao = rewardDaoMysqlImpl;
		} else {
			throw new IllegalArgumentException("Unknown data source " + dataSource);
		}
		return rewardDao;
	}
}
