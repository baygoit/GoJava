package ua.com.goit.gojava7.kickstarter.dao;

import java.io.File;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Category;


public class FileCategoryReader implements CategoryReader {
	private File categoryMusicFile;

	public FileCategoryReader(File categoryMusicFile) {
		this.categoryMusicFile = categoryMusicFile;
	}

	@Override
	public List<Category> readCategories() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
