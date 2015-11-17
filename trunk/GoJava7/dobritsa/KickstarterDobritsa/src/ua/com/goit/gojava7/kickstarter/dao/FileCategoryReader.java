package ua.com.goit.gojava7.kickstarter.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public class FileCategoryReader implements CategoryReader {
	private List<File> categoryMusicFile;

	public FileCategoryReader(List<File> categoriesFile) {
		this.categoryMusicFile = categoriesFile;
	}

	@Override
	public List<Category> readCategories() {
		List<Category> categories = new ArrayList<>();
		Category category;
		BufferedReader fileReader = null;
		try {
			for(File file: categoryMusicFile) {
				InputStream categoriesFileSteam = new FileInputStream(file);
				fileReader = new BufferedReader(new InputStreamReader(categoriesFileSteam));
				category = new Category(fileReader.readLine());
				
				while ((fileReader.readLine()) != null) {
					Project project = new Project();
					project.setName(fileReader.readLine());
					project.setDescription(fileReader.readLine());			
					project.setGoal(new Integer(fileReader.readLine()));
					project.setPledged(new Integer(fileReader.readLine()));
					project.setDaysToGo(new Integer(fileReader.readLine()));
					project.setHistory(fileReader.readLine());
					project.setLink(fileReader.readLine());
					// TODO addQuestion
					category.add(project);
				}
				categories.add(category);

			}
			
		} catch (IOException e) {
			throw new IllegalStateException("File not found or read error", e);
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					System.err.println("Cannot close file " + categoryMusicFile);
				}
			}
		}

		if (categories.isEmpty()) {
			throw new IllegalStateException("There is not categories in file");
		}
		
		return categories;
	}
}
