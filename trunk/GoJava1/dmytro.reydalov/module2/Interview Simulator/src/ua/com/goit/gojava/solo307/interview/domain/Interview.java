package ua.com.goit.gojava.solo307.interview.domain;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.solo307.interview.dao.CategoryDAO;
import ua.com.goit.gojava.solo307.interview.dao.InterviewDAO;
import ua.com.goit.gojava.solo307.interview.utils.InterviewSimulatorException;
import ua.com.goit.gojava.solo307.interview.utils.StatisticsDTO;

public class Interview {

	private InterviewDAO interviewDAO = new InterviewDAO();
	private CategoryDAO categoryDAO = new CategoryDAO();
	private List<Category> categories = new ArrayList<Category>();

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public void createCategories() throws InterviewSimulatorException {
		this.categories = categoryDAO.getCategoriesList();
		List<Question> questions = categoryDAO.getQuestions();
		categoryDAO.attachAnswers(questions);
		categoryDAO.fillCategories(categories, questions);
	}

	public void createCategories(String[] names) throws InterviewSimulatorException {
		this.categories = categoryDAO.getCategories(names);
		List<Question> questions = categoryDAO.getQuestions();
		categoryDAO.attachAnswers(questions);
		categoryDAO.fillCategories(categories, questions);
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
			start = interviewDAO.getStartTime();
		} catch (InterviewSimulatorException e) {
			e.printStackTrace();
		}
		return start;
	}

	public void addName(String name) {
		try {
			interviewDAO.addName(name);
		} catch (InterviewSimulatorException e) {
			e.getMessage();
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	public void addTime(long start) {
		try {
			interviewDAO.addStartTime(start);
		} catch (InterviewSimulatorException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	public void addStatistics(StatisticsDTO dto) {
		try {
			interviewDAO.addStatistics(dto);
		} catch (InterviewSimulatorException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
}