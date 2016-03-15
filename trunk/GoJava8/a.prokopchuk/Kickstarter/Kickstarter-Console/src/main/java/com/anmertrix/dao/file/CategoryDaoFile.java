package com.anmertrix.dao.file;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.anmertrix.Category;
import com.anmertrix.dao.CategoryDao;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CategoryDaoFile extends CategoryDao {

	private final static String baseFile = "./src/main/resources/categories.json";

	public void fillCategory() {
	    ObjectMapper mapper = new ObjectMapper();
	    
		try {
			categories = mapper.readValue(new File(baseFile), new TypeReference<List<Category>>(){
				//do nothinck
			});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
