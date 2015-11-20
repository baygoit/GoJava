
package ua.com.goit.gojava7.kickstarter.storage_in_files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.AbstractFilesStorage;
import ua.com.goit.gojava7.kickstarter.model.Category;

public class CategoriesStorage extends AbstractFilesStorage<Category> {
	
//	private static final File FILE_FOR_TEST = new File("./resources/categories.csv");
	private static final File REWARDS_FILE = new File("./categories.csv");
	
	private static final int UNIQUE_ID = 0;
	private static final int CATEGORY_NAME = 1;

	@Override
	public void add(Category element) {
		
		FileWriter fileWriter = null;

		try {

			fileWriter = new FileWriter(REWARDS_FILE, true);
			
			fileWriter.append(String.valueOf(element.getUniqueID()));
			fileWriter.append(SEMICOLON_DELIMITER);
			fileWriter.append(element.getCategoryName());
			fileWriter.append(NEW_LINE_SEPARATOR);

			fileWriter.flush();
			
		} catch (IOException e) {
			System.err.println("Error in CSVFileReader...");
		} finally {
	
			try {
				if (fileWriter != null ) {
					fileWriter.close();
				}
			} catch (IOException e) {
				System.err.println("Error with closing fileReader...");
			}
		}
	}

	@Override
	public List<Category> getAll() {
		List<Category> categories = new ArrayList<>();
		String line = "";
		
		BufferedReader fileReader = null;
		
		try {
			
			fileReader = new BufferedReader(new FileReader(REWARDS_FILE));
			
			fileReader.readLine();
			
			fileReader.readLine();
			
			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.split(SEMICOLON_DELIMITER);
				if (tokens.length > 0) {
					
					Category category = new Category(tokens[CATEGORY_NAME]);
					
					category.setUniqueID(Integer.parseInt(tokens[UNIQUE_ID]));
					
					categories.add(category);
		
				}
			}
			
		} catch (IOException e) {
			System.err.println("Error in CSVFileReader...");
		} finally {
	
			try {
				if (fileReader != null ) {
					fileReader.close();
				}
			} catch (IOException e) {
				System.err.println("Error with closing fileReader...");
			}
		}

		return categories;
	}
	
	public int getSize() {
		return getAll().size();
	}
	
	@Override
	public void remove(Category element) {
		// TODO Auto-generated method stub	
	}
}
