package edu.kickstarter.DAO.category;

import java.util.List;
import edu.kickstarter.database.KickstarterException;
import edu.kickstarter.entity.Category;

public interface CategoryService {

	List<Category> getAll() throws KickstarterException;
}
