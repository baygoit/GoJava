package ua.com.goit.gojava7.kikstarter.dao.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kikstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kikstarter.domain.Category;

public class CategoryDaoFile implements CategoryDao {

	private static final String SEMICOLON = ";";
	private File file;
	private FileWriter fileWriter;

	public CategoryDaoFile() {
		file = new File("./resources/categories.csv");
	}

	@Override
	public void add(Category category) {
		String categoryString = (category.getUniqueID() + SEMICOLON + category.getName() + "\n");
		fileWriter = null;

		try {
			fileWriter = new FileWriter(file, true);
			fileWriter.append(categoryString);
			fileWriter.flush();
		} catch (Exception e) {
			System.out.println("CSV file writting error");
		} finally {
			try {
				if (fileWriter != null) {
					fileWriter.close();
				}
			} catch (IOException e) {
				System.err.println("Error with closing fileReader");
			}
		}

	}

	@Override
	public void remove(Category category) {
		System.out.println("Remove will be developed in further");
	}

	@Override
	public List<Category> getAll() {
		List<Category> categories = new ArrayList<>();
		String line = "";
		BufferedReader fileReader = null;

		try {
			fileReader = new BufferedReader(new FileReader(file));

			while ((line = fileReader.readLine()) != null) {
				String[] splitString = line.split(SEMICOLON);
				Category category = new Category(Integer.parseInt(splitString[0]), splitString[1]);
				categories.add(category);
			}
		} catch (Exception e) {
			System.out.println("Error in Read CSV file.");
		} finally {
			try {
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
				System.err.println("Error with closing fileReader...");
			}
		}

		return categories;
	}

	@Override
	public int getSize() {
		return getAll().size();
	}

}
