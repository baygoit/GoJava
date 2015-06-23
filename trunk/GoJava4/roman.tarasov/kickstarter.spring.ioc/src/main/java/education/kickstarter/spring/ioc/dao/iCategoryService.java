package education.kickstarter.spring.ioc.dao;


import java.sql.SQLException;
import java.util.List;

import education.kickstarter.spring.ioc.model.Category;


public interface iCategoryService {

	List<Category> getAll() throws SQLException, KickstarterException;

}
