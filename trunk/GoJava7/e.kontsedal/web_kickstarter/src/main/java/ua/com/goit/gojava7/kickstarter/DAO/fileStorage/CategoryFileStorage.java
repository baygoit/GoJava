package ua.com.goit.gojava7.kickstarter.DAO.fileStorage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import ua.com.goit.gojava7.kickstarter.DAO.AbstractCategoryStorage;
import ua.com.goit.gojava7.kickstarter.model.Category;

public class CategoryFileStorage extends AbstractCategoryStorage {
	private static int idGenerator;
	private File categoryFile;
	List<String> categoryLines;

	public CategoryFileStorage() {
		idGenerator = 0;
		categoryFile = new File("./resources/categories.csv");
		ReadFile();
	}

	private void ReadFile() {
		try {
			categoryLines = FileUtils.readLines(categoryFile);
			if (categoryLines.size() > 0) {
				String[] id = categoryLines.get(categoryLines.size() - 1).split(";");
				idGenerator = Integer.parseInt(id[0]);
			}
		} catch (IOException e) {
			System.err.println("CSV file reading error");
		}
	}

	@Override
	public List<Category> getAll() {
		ReadFile();
		List<Category> allCategories = new ArrayList<>();
		for (String categoryLine : categoryLines) {
			String[] splittedCategoryLine = categoryLine.split(";");
			Category category = new Category();
			category.setIdCategory(Integer.parseInt(splittedCategoryLine[0]));
			category.setCategoryName(splittedCategoryLine[1]);
			allCategories.add(category);
		}
		return allCategories;
	}

	public int getIdOfCategory(int numberOfCategory) {
		return getAll().get(numberOfCategory).getIdCategory();
	}

	public Category getCategoryById(int idOfCategory) {
		for (Category category : getAll()) {
			if (category.getIdCategory() == idOfCategory) {
				return category;
			}
		}
		return null;
	}

	@Override
	public void add(Category category) {
		StringBuilder categoryLine = new StringBuilder(++idGenerator + ";");
		categoryLine.append(category.getCategoryName() + "\n");

		try {
			FileUtils.writeStringToFile(categoryFile, categoryLine.toString(), true);
		} catch (IOException e) {
			System.err.println("CSV file writting error");
		}
	}
}
