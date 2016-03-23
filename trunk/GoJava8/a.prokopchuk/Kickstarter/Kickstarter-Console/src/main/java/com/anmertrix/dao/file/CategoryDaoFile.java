package com.anmertrix.dao.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.anmertrix.Category;
import com.anmertrix.dao.CategoryDao;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CategoryDaoFile implements CategoryDao {

	private final static String baseFile = "./src/main/resources/categories.json";
	protected List<Category> categories = new ArrayList<Category>();

	public void fillCategory() {
	    ObjectMapper mapper = new ObjectMapper();
	    
		try {
			categories = mapper.readValue(new File(baseFile), new TypeReference<List<Category>>(){});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }

	@Override
	public Category getCategory(int index) {
		return categories.get(index - 1);
	}

	@Override
	public List<Category> getCategories() {
		return categories;
	}
	
	
}
