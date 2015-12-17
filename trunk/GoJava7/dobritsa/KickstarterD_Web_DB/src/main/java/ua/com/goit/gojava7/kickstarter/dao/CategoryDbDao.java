package ua.com.goit.gojava7.kickstarter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import ua.com.goit.gojava7.kickstarter.models.Category;

@Component
public class CategoryDbDao extends DbDao<Category> {

	private static final Logger log = LoggerFactory.getLogger(CategoryDbDao.class);
	private static final String TABLE = "category";
	private static final String FIELDS = "id, name";

	public CategoryDbDao() {
		log.info("Constructor CategoryDbDao()...");
		super.TABLE = TABLE;
		super.FIELDS = FIELDS;
	}

	public CategoryDbDao(BasicDataSource basicDataSource) {
		super(basicDataSource, FIELDS, TABLE);
	}

	@Override
	protected Category readElement(ResultSet resultSet) throws SQLException {
		log.info("readElement()...");
		Category category = new Category();
		category.setId(resultSet.getInt("id"));
		category.setName(resultSet.getString("name"));
		log.debug("readElement() returned category: {}", category);
		return category;
	}
}
