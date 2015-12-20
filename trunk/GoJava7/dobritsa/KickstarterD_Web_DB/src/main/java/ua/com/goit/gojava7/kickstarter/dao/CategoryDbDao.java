package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.models.Category;

@Component
public class CategoryDbDao {

	@Autowired
	private DbManager dbManager;

	private static final Logger log = LoggerFactory.getLogger(CategoryDbDao.class);
	private static final String TABLE = "category";
	private static final String FIELDS = "id, name";

	public CategoryDbDao() {
		log.info("Constructor CategoryDbDao()...");
	}

	public List<Category> getAll() {
		log.info("<Category> getAll()...");
		String query = "select id, name from category";
		return dbManager.getCategories(query);
	}

	public Category get(int index) {
		log.info("<Category> get({})...", index);
		String query = "select " + FIELDS + " from " + TABLE + " where id = " + index;
		return dbManager.getCategory(query);
	}
}
