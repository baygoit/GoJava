package ua.nenya.dao.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ua.nenya.project.Category;
import ua.nenya.dao.CategoryDao;

public class CategoryDaoFileImpl implements CategoryDao {
	private List<Category> categories = new ArrayList<Category>();
	private String fileName = "src/main/resources/caterories.json";
	

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<Category> getCategories() {
		return categories;
	}

	@Override
	public void initCategories() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			categories = mapper.readValue(new File(fileName), new TypeReference<List<Category>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
