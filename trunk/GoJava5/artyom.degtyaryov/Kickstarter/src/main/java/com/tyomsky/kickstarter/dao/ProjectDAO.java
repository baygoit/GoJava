package com.tyomsky.kickstarter.dao;

import com.tyomsky.kickstarter.dao.common.BasicCrudDao;
import com.tyomsky.kickstarter.domain.Category;
import com.tyomsky.kickstarter.domain.Project;

import java.util.List;

public interface ProjectDAO extends BasicCrudDao<Project> {

    List<Project> getListByCategory(Category category);

}
