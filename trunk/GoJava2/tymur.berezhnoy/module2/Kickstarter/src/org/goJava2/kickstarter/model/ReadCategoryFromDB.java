package org.goJava2.kickstarter.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import org.goJava2.kickstarter.content.Category;

public class ReadCategoryFromDB {
	
	private String fileName = "DataBase/Categories.mdb";
	
	private Set<Category> categories;
	
	private BufferedReader reader;
	
	public Set<Category> getCategoryFromFile() {
		String line;
		
		categories = new LinkedHashSet<Category>();
		
		try {
			reader = new BufferedReader(new FileReader(fileName));
			
			while ((line = reader.readLine()) != null) {
				categories.add(new Category(line));
			}
		} catch (FileNotFoundException e) {
			System.out.println("There are no file");
		} catch (IOException e) {
			System.out.println("There are something wrong!");
		} finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (Exception e2) {
					System.out.println("Can't close file");
				}
			}
		}
		return categories;
	}
}