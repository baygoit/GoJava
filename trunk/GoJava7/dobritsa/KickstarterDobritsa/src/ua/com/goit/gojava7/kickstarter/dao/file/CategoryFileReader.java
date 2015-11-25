package ua.com.goit.gojava7.kickstarter.dao.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.FileReader;
import ua.com.goit.gojava7.kickstarter.domain.Category;

public class CategoryFileReader extends FileReader<Category>{

	public CategoryFileReader(File file) {
		super(file);
	}

	@Override
	public List<Category> readFromFile(BufferedReader bufferedReader) throws IOException {

		String line;
		while ((line = bufferedReader.readLine()) != null) {
			Category category = new Category(line);
			data.add(category);
		}
		return data;
	}
}
