package com.sandarovich.kickstarter.io;

import com.sandarovich.kickstarter.dao.DaoMode;
import com.sandarovich.kickstarter.dao.category.CategoryDao;
import com.sandarovich.kickstarter.dao.quote.QuoteDao;
import com.sandarovich.kickstarter.domain.Category;
import com.sandarovich.kickstarter.domain.Project;

import java.util.List;

/**
 * @author Olexander Kolodiazhny 2016 
 * Describe common text output
 */

public interface IO {
    void write(String message);
    String read();

    void writeAllProjectsAsTable(List<Project> projects);
    void writeCategory(Category category);
    void writeAllCategoriesAsList(CategoryDao categoryDao);
    void writeViewTitle(String titleName);
    void writeApplicationTitle();
    void writeQuote(QuoteDao quoteDao);
    void writeDaoMode(DaoMode daoMode);
    void writeAllProjectsAsList(CategoryDao categoryDao, Category category);
    void writeProjectDetails(Project project);
    void writeProjectAwards(CategoryDao categoryDao, Project project);
}
