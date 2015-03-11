package ua.com.goit.gojava2.solo307.interview;

import java.util.ArrayList;
import java.util.List;

public class Interview {

	private static InterviewDAO interviewDAO;
	private static CategoryDAO categoryDAO;
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
		categoryDAO.fillQuestions(questions);
		categoryDAO.fillCategories(categories, questions);
	}

	public void createCategories(String[] names) throws InterviewSimulatorException {
		this.categories = categoryDAO.getCategories(names);
		List<Question> questions = categoryDAO.getQuestions();
		categoryDAO.fillQuestions(questions);
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

	public static long readStartTime() {
		long start = 0;
		try {
			start = interviewDAO.readStartTime();
		} catch (InterviewSimulatorException e) {
			e.printStackTrace();
		}
		return start;
	}

	public static void persistName(String name) {
		try {
			interviewDAO.writeName(name);
		} catch (InterviewSimulatorException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void persistTime(long start) {
		try {
			interviewDAO.writeTime(start);
		} catch (InterviewSimulatorException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	public static void persistStatistics(StatisticsDTO dto) {
		try {
			interviewDAO.persistStatistics(dto);
		} catch (InterviewSimulatorException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
}