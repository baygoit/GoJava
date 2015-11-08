package ua.com.goit.gojava.solo307.intersim.domain;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.solo307.intersim.commons.StatisticsTraveler;
import ua.com.goit.gojava.solo307.intersim.dao.CategoryDao;
import ua.com.goit.gojava.solo307.intersim.dao.InterviewDao;
import ua.com.goit.gojava.solo307.intersim.dao.InterviewSimulatorDaoException;

public class Interview {

	private InterviewDao interviewDao = new InterviewDao();
	private static CategoryDao categoryDao = new CategoryDao();
	private List<Category> categories = new ArrayList<Category>();

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public static List<Category> getAllCategories() {
		List<Category> categories = new ArrayList<Category>();
		try {
			categories = categoryDao.getCategoriesList();
		} catch (InterviewSimulatorDaoException e) {
			LoggerDomain.domainLogger.error(e);
		}
		List<Question> questions = null;
		try {
			questions = categoryDao.getQuestions();
		} catch (InterviewSimulatorDaoException e) {
			LoggerDomain.domainLogger.error(e);
		}
		try {
			categoryDao.attachAnswers(questions);
		} catch (InterviewSimulatorDaoException e) {
			LoggerDomain.domainLogger.error(e);
		}
		categories = categoryDao.fillCategories(categories, questions);
		return categories;
	}

	public void createCategories(String[] names)
			throws InterviewSimulatorDomainException {
		try {
			this.categories = categoryDao.getCategories(names);
		} catch (InterviewSimulatorDaoException e) {
			LoggerDomain.domainLogger.error(e);
		}
		List<Question> questions = null;
		try {
			questions = categoryDao.getQuestions();
		} catch (InterviewSimulatorDaoException e) {
			LoggerDomain.domainLogger.error(e);
		}
		try {
			categoryDao.attachAnswers(questions);
		} catch (InterviewSimulatorDaoException e) {
			LoggerDomain.domainLogger.error(e);
		}
		categoryDao.fillCategories(categories, questions);
	}

	public Category getComposedCategory() {
		final int CATEGORY_ID = 999;
		final String CATEGORY_NAME = "composite";
		Category composed = new Category(CATEGORY_NAME, CATEGORY_ID);
		for (Category category : categories) {
			composed.addQuestions(category.getQuestions());
		}
		return composed;
	}

	public long getStartTime() {
		long start = 0;
		try {
			start = interviewDao.getStartTime();
		} catch (InterviewSimulatorDaoException e) {
			e.printStackTrace();
		}
		return start;
	}

	public void addName(String name) {
		try {
			interviewDao.addName(name);
		} catch (InterviewSimulatorDaoException e) {
			e.getMessage();
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	public void addTime(long start) {
		try {
			interviewDao.addStartTime(start);
		} catch (InterviewSimulatorDaoException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	public void addStatistics(StatisticsTraveler dto) {
		try {
			interviewDao.addStatistics(dto);
		} catch (InterviewSimulatorDaoException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	public void fillCategories() {
		try {
			this.categories = categoryDao.getCategoriesList();
		} catch (InterviewSimulatorDaoException e) {
			LoggerDomain.domainLogger.error(e);
		}
		List<Question> questions = null;
		try {
			questions = categoryDao.getQuestions();
		} catch (InterviewSimulatorDaoException e) {
			LoggerDomain.domainLogger.error(e);
		}
		try {
			categoryDao.attachAnswers(questions);
		} catch (InterviewSimulatorDaoException e) {
			LoggerDomain.domainLogger.error(e);
		}
		categories = categoryDao.fillCategories(categories, questions);
	}
}
