package com.sandarovich.kickstarter.io;

import com.sandarovich.kickstarter.dao.DaoMode;
import com.sandarovich.kickstarter.dao.category.CategoryDao;
import com.sandarovich.kickstarter.dao.quote.QuoteDao;
import com.sandarovich.kickstarter.domain.Category;
import com.sandarovich.kickstarter.domain.Project;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class WebIO implements IO {

    private PrintWriter out;

    public WebIO(HttpServletResponse res) {
        try {
            out = res.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(String message) {
        out.println(message);
    }

    @Override
    public String read() {
        return null;
    }

    @Override
    public void writeAllProjectsAsTable(List<Project> projects) {

    }

    @Override
    public void writeCategory(Category category) {

    }

    @Override
    public void writeAllCategoriesAsList(CategoryDao categoryDao) {

    }

    @Override
    public void writeViewTitle(String titleName) {

    }

    @Override
    public void writeApplicationTitle() {

    }

    @Override
    public void writeQuote(QuoteDao quoteDao) {

    }

    @Override
    public void writeDaoMode(DaoMode daoMode) {

    }

    @Override
    public void writeAllProjectsAsList(CategoryDao categoryDao, Category category) {

    }

    @Override
    public void writeProjectDetails(Project project) {

    }

    @Override
    public void writeProjectAwards(CategoryDao categoryDao, Project project) {

    }
}
