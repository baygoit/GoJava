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
	

	public List<Category> getCategories() {
		return categories;
	}

	@Override
	public void initCategories() {
		File file = new File("src/main/resources/caterories.json");
		ObjectMapper mapper = new ObjectMapper();
		try {
			categories = mapper.readValue(file, new TypeReference<List<Category>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
