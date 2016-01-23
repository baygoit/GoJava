package ua.com.goit.gojava7.kickstarter.datasource.contract;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.CategoryStatistic;

public interface CategoryDAO extends DataSource<Category>{

	List<CategoryStatistic> getTopDonated(int limit);
    
}
