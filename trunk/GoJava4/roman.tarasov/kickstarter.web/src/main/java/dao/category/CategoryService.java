package dao.category;

import java.util.List;
import database.KickstarterException;

public interface CategoryService {

	List<Category> getAll() throws KickstarterException;
}
