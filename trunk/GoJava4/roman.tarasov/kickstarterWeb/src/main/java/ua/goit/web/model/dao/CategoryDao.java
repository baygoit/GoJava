package ua.goit.web.model.dao;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface CategoryDao {

	List<Category> getAll() throws KickstarterException;
}
