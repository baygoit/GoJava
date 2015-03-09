package ua.com.goit.gojava2.solo307.interview;

import java.util.ArrayList;
import java.util.List;

public class Interview {

	private InterviewDAO interviewDAO = new InterviewDAO();
	private List<Category> categories = new ArrayList<Category>();
	private CategoryDAO categoryDao = new CategoryDAO();

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public void createCategories() throws InterviewSimulatorException {
		this.categories = categoryDao.getCategoriesList();
		List<Question> questions = categoryDao.getQuestions();
		categoryDao.fillQuestions(questions);
		categoryDao.fillCategories(categories, questions);
	}

	public void createCategories(String[] names)
			throws InterviewSimulatorException {
		this.categories = categoryDao.getCategories(names);
		List<Question> questions = categoryDao.getQuestions();
		categoryDao.fillQuestions(questions);
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

	public long readStartTime() {
		long start = 0;
		try {
			start = interviewDAO.readStartTime();
		} catch (InterviewSimulatorException e) {
			e.printStackTrace();
		}
		return start;
	}

	public void persistName(String name) {
		try {
			interviewDAO.writeName(name);
		} catch (InterviewSimulatorException e) {
			System.out.println(e.getMessage());
		}
	}

	public void persistTime(long start) {
		try {
			interviewDAO.writeTime(start);
		} catch (InterviewSimulatorException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private void persistDuration(String time) {
		try {
			interviewDAO.writeDuration(time);
		} catch (InterviewSimulatorException e) {
			e.printStackTrace();
		}
	}

	private void persistDate(String date) {
		try {
			interviewDAO.persistDate(date);
		} catch (InterviewSimulatorException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	public void persistStatistics(StatisticsDTO dto) {
		persistDate(dto.date);
		persistDuration(dto.duration);
		try {
			interviewDAO.persistMarks(dto);
		} catch (InterviewSimulatorException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
}
