package dao.category;

import java.util.List;
import dao.pool.KickstarterException;

public interface CategoryService {

	List<Category> getAll() throws KickstarterException;
}
