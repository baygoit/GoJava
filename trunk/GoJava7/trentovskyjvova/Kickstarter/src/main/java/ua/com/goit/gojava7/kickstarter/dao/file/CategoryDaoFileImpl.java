package ua.com.goit.gojava7.kickstarter.dao.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.exception.WrongFileFormatException;

public class CategoryDaoFileImpl implements CategoryDao {
	private static final String CSV_SPLIT_BY = ";";
	private File categoriesFile;
	
	public CategoryDaoFileImpl(File categoriesFile) {
		this.categoriesFile = categoriesFile;
	}

	@Override
	public List<Category> getCategories() {
		List<Category> categories = new ArrayList<>();
		
		BufferedReader fileReader = null;
		try {
			InputStream categoriesFileSteam = new FileInputStream(
					categoriesFile);
			fileReader = new BufferedReader(new InputStreamReader(
					categoriesFileSteam));

			String line = null;
			int id = 0;
			String name = null;
			while (null != (line = fileReader.readLine())) {
				String[] categoryLine = line.split(CSV_SPLIT_BY);
				if (categoryLine.length < 2) {
					throw new WrongFileFormatException("Wrong categories.csv format.");
				} else if (categoryLine[0] == "") {
					throw new WrongFileFormatException(
							"Wrong categories.csv format. Cannot find category id");
				} else if (categoryLine[1] == "") {
					throw new WrongFileFormatException(
							"Wrong categories.csv format. Cannot find category name");
				}
				id = Integer.parseInt(categoryLine[0]);
				name = categoryLine[1];
				
				Category category = new Category();
				category.setId(id);
				category.setName(name);
				categories.add(category);
			}
		} catch (IOException e) {
			throw new WrongFileFormatException("File not found or read error", e);
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					System.err.println("Cannot close file " + categoriesFile);
				}
			}
		}

		if (categories.isEmpty()) {
			throw new WrongFileFormatException("There is not categories in file");
		}

		return categories;
	}

	@Override
	public int size() {
		return getCategories().size();
	}

	@Override
	public Category getCategory(int id) {
		Category result = null;
		for (Category category : getCategories()) {
			if(category.getId() == id){
				result = category;
				break;
			}
		}
		return result;
	}

	@Override
	public Category getBestCategory() {
		// TODO Auto-generated method stub
		return null;
	}

}
