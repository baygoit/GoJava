package ua.com.goit.gojava7.kickstarter.dao;

import java.io.File;
import java.io.IOException;

import java.util.List;
import ua.com.goit.gojava7.kickstarter.domain.Category;

public class FileCategoryReader extends FileReader<Category> implements CategoryReader {

	public FileCategoryReader(File file) {
		super(file);
	}

	@Override
	public List<Category> readIt() throws IOException {

		String line;
		while ((line = fileReader.readLine()) != null) {
			Category category = new Category(line);
			FileProjectReader fpr = new FileProjectReader(new File(fileReader.readLine()));
			category.setAll(fpr.read());
			data.add(category);
		}
		return data;
	}
}
