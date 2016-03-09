package com.goit.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.goit.logic.Category;

public class CategoryFileReader {
	Category category;
	File file;

	CategoryFileReader(String filePath) {
		file = new File(filePath);
		category = new Category();
		category.setName(file.getName());
	}

	private void setProjects() throws IOException {
		BufferedReader buffereadReader = new BufferedReader(new FileReader(file));
		String line;
		category.addProject("exit");
		while ((line = buffereadReader.readLine()) != null) {
			category.addProject(line);
		}
		buffereadReader.close();
	}
	
	public Category getCategory() throws IOException{
		setProjects();
		return category;
	}
	
}
