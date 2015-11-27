package ua.com.goit.gojava7.kickstarter.dao.memory;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.memory.util.MemoryDAO;
import ua.com.goit.gojava7.kickstarter.domain.Category;

public class CategoryMemoryDAO extends MemoryDAO<Category> implements CategoryDAO{

    public CategoryMemoryDAO(List<Category> dataSource) {
        super(dataSource);
    }

}
