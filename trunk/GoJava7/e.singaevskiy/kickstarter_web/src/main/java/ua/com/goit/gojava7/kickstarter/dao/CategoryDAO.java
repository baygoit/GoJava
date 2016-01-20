package ua.com.goit.gojava7.kickstarter.dao;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Category;

public interface CategoryDAO extends DataSource<Category>{

	List<ua.com.goit.gojava7.kickstarter.domain.CategoryStatistic> getTopDonated(int limit);
    
}
