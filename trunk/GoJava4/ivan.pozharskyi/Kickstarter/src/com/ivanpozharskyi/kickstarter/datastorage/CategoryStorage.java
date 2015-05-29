package com.ivanpozharskyi.kickstarter.datastorage;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CategoryStorage {

	private Set<Category> categorys = new HashSet<Category>();
	private ReaderFromFile readerFromFile;

	public Category getCategory(int id) {

		for (Category category : categorys) {
			if (category.getCategoryId() == id) {
				return category;
			}

		}
		return null;
	}
	public void addCategoriesFromFile(String fileName) throws IOException{
		readerFromFile = new ReaderFromFile(fileName);
		List<String> categorysNames = readerFromFile.read();
		for(String categorysName: categorysNames){
			Category category = new Category(categorysName);
			categorys.add(category);
		}

	}
	
	public void addCategory(Category category) {
		categorys.add(category);
	}

	public Set<Category> getAllCategorys() {
		return categorys;
	}

	public int getSize() {
		return categorys.size();
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Category category : categorys) {
			result.append(category.toString() + "\n");
		}
		return result.toString();
	}

}
